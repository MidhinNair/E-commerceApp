package dev.midhin.productservice.service;

import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.model.Product;

public interface ProductService {
   // public String getProductById(Long id);
    public GenericProductDto getProductById(Long id);

}
