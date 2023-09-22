package dev.midhin.productservice.controller;

import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

//field injection and setter  injection is not recomented
//constructor injection in latest version of springboot do not need to autowired
@Autowired
public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
    this.productService = productService;
}

    @GetMapping("")
   public ResponseEntity<List<GenericProductDto>> getAllProduct(){
    List<GenericProductDto> allProduct = productService.getAllProduct ();
   return null;

  }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id ){
    return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id ){
        productService.deleteProductById (id);
        System.out.println ("product deleted of id ="+id);
    }
    @PostMapping("")  //what ever is the request body please convert to genericDto
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto ){
        System.out.println (genericProductDto.getDescription ());
    return productService.createProduct (genericProductDto);

    }
    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id , @RequestBody GenericProductDto genericProductDto ){
        System.out.println ("Product updated of id ="+id);
        return productService.updateProductById (id,genericProductDto);
    }
}
