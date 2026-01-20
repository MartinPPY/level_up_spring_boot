package com.levelup.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Long stock;


    private Long stockCritico;
    
    private String image;

    @ManyToOne
    private Category category;

    

}
