package com.levelup.app.models.dtos;

public class ProductDto {

    private String code;

    private String name;

    private String description;

    private Double precio;

    private Long stock;

    private Long stockCritico;

    private String image;

    private Integer category;

    public ProductDto() {
    }

    public ProductDto(String code, String name, Double precio, Long stock, Long stockCritico, String description,
            String image,
            Integer category) {
        this.code = code;
        this.name = name;
        this.precio = precio;
        this.stock = stock;
        this.stockCritico = stockCritico;
        this.image = image;
        this.category = category;
        this.description = description;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
