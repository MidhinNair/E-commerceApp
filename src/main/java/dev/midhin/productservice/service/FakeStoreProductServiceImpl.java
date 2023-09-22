package dev.midhin.productservice.service;

import dev.midhin.productservice.Dtos.FakeStoreProductDto;
import dev.midhin.productservice.Dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements  ProductService{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductByIdRequestUrl ="https://fakestoreapi.com/products/{id}";
    private String CreateProductRequestUrl ="https://fakestoreapi.com/products";
    private String updateProductRequestUrl ="https://fakestoreapi.com/products/{id}";
    private String deleteProductRequestUrl ="https://fakestoreapi.com/products/{id}";
    private String getAllProductRequestUrl ="https://fakestoreapi.com/products";


    @Override
    public List<GenericProductDto> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build ();
        //when ever you do a generic arraylist this datatype is only compile at runtime

        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity (getAllProductRequestUrl,FakeStoreProductDto[].class );

        List<GenericProductDto> ans = new ArrayList<> ();
        for(FakeStoreProductDto fakeStoreProductDto : response.getBody ()){
            GenericProductDto product = new GenericProductDto ();
            product.setTitle (fakeStoreProductDto.getTitle ());
            product.setCategory (fakeStoreProductDto.getCategory ());
            product.setPrice (fakeStoreProductDto.getPrice ());
            product.setDescription (fakeStoreProductDto.getDescription ());
            product.setImage (fakeStoreProductDto.getImage ());
            ans.add (product);
        }
        return ans;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build ();

        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity (getProductByIdRequestUrl, FakeStoreProductDto.class,id);//post/put

        FakeStoreProductDto fakeStoreProductDto = response.getBody ();
        GenericProductDto product = new GenericProductDto ();

        product.setTitle (fakeStoreProductDto.getTitle ());
        product.setCategory (fakeStoreProductDto.getCategory ());
        product.setPrice (fakeStoreProductDto.getPrice ());
        product.setDescription (fakeStoreProductDto.getDescription ());
        product.setImage (fakeStoreProductDto.getImage ());
        return product;
    }
    @Override
    public GenericProductDto updateProductById(Long id , GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build ();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity (updateProductRequestUrl,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody ();
        GenericProductDto updatedGenericProductDto = new GenericProductDto ();

        updatedGenericProductDto.setCategory (fakeStoreProductDto.getCategory ());
        updatedGenericProductDto.setId (fakeStoreProductDto.getId ());
        updatedGenericProductDto.setDescription (fakeStoreProductDto.getDescription ());
        updatedGenericProductDto.setTitle (fakeStoreProductDto.getTitle ());
        updatedGenericProductDto.setPrice (fakeStoreProductDto.getPrice ());
        updatedGenericProductDto.setImage (fakeStoreProductDto.getImage ());
        return updatedGenericProductDto;
    }

    public GenericProductDto createProduct (GenericProductDto genericProductDto){
        RestTemplate restTemplate = restTemplateBuilder.build ();
        ResponseEntity<GenericProductDto> response =
               restTemplate.postForEntity (CreateProductRequestUrl,genericProductDto,GenericProductDto.class);
       return response.getBody ();
    }

    @Override
    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build ();
        restTemplate.delete (deleteProductRequestUrl,id);
    }


}
