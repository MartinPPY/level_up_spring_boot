package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelup.app.models.Product;
import com.levelup.app.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository regionRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) regionRepository.findAll();
    }


    
}