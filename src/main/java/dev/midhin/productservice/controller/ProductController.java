package dev.midhin.productservice.controller;

import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products/")
public class ProductController {

    private final ProductService productService;

//field injection and setter  injection is not recomented
//constructor injection in latest version of springboot do not need to autowired
@Autowired
public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
    this.productService = productService;
}

    @GetMapping("")
    public void getAllProduct(){

    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id ){
    return productService.getProductById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id ){

    }
    @PostMapping("")
    public void createProduct(){

    }
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id ){

    }
}
