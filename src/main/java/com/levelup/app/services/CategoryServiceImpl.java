package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelup.app.models.Category;
import com.levelup.app.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {        
        return (List<Category>) categoryRepository.findAll();
    }


    
}
