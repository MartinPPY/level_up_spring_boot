package com.levelup.app.models;

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

    public Product() {
    }

    public Product(String code, String name, Double precio, Long stock, Long stockCritico, String image,
            Category category) {
        this.code = code;
        this.name = name;
        this.precio = precio;
        this.stock = stock;
        this.stockCritico = stockCritico;
        this.image = image;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(Long stockCritico) {
        this.stockCritico = stockCritico;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    

}
