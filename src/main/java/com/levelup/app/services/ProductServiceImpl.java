package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.models.Category;
import com.levelup.app.models.Product;
import com.levelup.app.models.dtos.ProductDto;
import com.levelup.app.repositories.CategoryRepository;
import com.levelup.app.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    @Override
    public Product save(ProductDto product) {
        System.out.println(product.getCode());

        Category category = categoryRepository.findById(product.getCategory().longValue()).orElseThrow();

        Product producto = new Product(product.getCode(), product.getName(),
                product.getPrecio(), product.getStock(), product.getStockCritico(),
                product.getDescription(), product.getImage(), category);


        return productRepository.save(producto);
    }

}