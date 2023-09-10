package dev.midhin.productservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products/")
public class ProductController {
    @GetMapping("")
    public void getAllProduct(){

    }
    @GetMapping("/{id}")
    public void getProductById(){

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }
    @PostMapping("")
    public void createProduct(){

    }
    @PutMapping("/{id}")
    public void updateProduct(){

    }
}
