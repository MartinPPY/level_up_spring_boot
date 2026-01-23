package com.levelup.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levelup.app.models.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    
}
