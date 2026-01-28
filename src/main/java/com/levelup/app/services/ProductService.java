package com.levelup.app.services;

import java.util.List;

import com.levelup.app.models.Product;
import com.levelup.app.models.dtos.ProductDto;

public interface ProductService {
    

    List<Product> findAll();

    ProductDto findProductDto(String code);

    Product save (ProductDto product);
    
    void deleteById(String code);

}