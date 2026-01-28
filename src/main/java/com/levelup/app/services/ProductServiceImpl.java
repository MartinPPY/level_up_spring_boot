package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.exception.NotFoundException;
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

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    @Override
    public Product save(ProductDto product) {
        
        Category category = categoryRepository.findById(product.getCategory().longValue()).orElseThrow(
            ()-> new NotFoundException("Categoria no encontrada!")
        );

        Product producto = new Product(product.getCode(), product.getName(),
                product.getPrecio(), product.getStock(), product.getStockCritico(),
                product.getDescription(), product.getImage(), category);


        return productRepository.save(producto);
    }

    @Transactional
    @Override
    public void deleteById(String code) {
        Product product = productRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(product);
    }



}