package dev.midhin.productservice.service;

import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.model.Product;

import java.util.List;

public interface ProductService {
     List<GenericProductDto> getAllProduct();
    GenericProductDto getProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void deleteProductById(Long id);
    GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto);

}
