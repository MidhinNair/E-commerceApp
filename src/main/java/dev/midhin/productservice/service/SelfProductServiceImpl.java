package dev.midhin.productservice.service;

import dev.midhin.productservice.Dtos.GenericProductDto;
import dev.midhin.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service

public class SelfProductServiceImpl implements  ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
