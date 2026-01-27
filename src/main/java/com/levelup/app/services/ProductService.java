package com.levelup.app.services;

import java.util.List;

import com.levelup.app.models.Product;
import com.levelup.app.models.dtos.ProductDto;

public interface ProductService {
    

    List<Product> findAll();

    Product save (ProductDto product);
    

}