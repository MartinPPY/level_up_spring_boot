package com.levelup.app.models.dtos;

public class VentaDto {

    private Integer cantidad;
    private String code;
    private Integer precio;
    private String email;

    public VentaDto() {
    }

    public VentaDto(Integer cantidad, String code, Integer precio, String email) {
        this.cantidad = cantidad;
        this.code = code;
        this.precio = precio;
        this.email = email;
    }

    

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
