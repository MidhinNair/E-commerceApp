package dev.midhin.productservice.controller;

import dev.midhin.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products/")
public class ProductController {
    private  ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("")
    public void getAllProduct(){

    }
    @GetMapping("/{id}")
    public void getProductById(@PathVariable("id") Long id ){

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
