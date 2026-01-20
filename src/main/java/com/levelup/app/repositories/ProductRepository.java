package com.levelup.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levelup.app.entities.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
