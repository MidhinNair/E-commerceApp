package dev.midhin.productservice.service;

import dev.midhin.productservice.Dtos.FakeStoreProductDto;
import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductByIdRequestUrl ="https://fakestoreapi.com/products/{id}";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build ();

        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity (getProductByIdRequestUrl, FakeStoreProductDto.class, id);//post/put

        FakeStoreProductDto fakeStoreProductDto = response.getBody ();
        GenericProductDto product = new GenericProductDto ();

        product.setTitle (fakeStoreProductDto.getTitle ());
        product.setCategory (fakeStoreProductDto.getCategory ());
        product.setPrice (fakeStoreProductDto.getPrice ());
        product.setDescription (fakeStoreProductDto.getDescription ());
        product.setImage (fakeStoreProductDto.getImage ());
      //  response.getStatusCode ();
        return product;
    }
}
