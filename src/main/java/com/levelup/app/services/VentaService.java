package com.levelup.app.services;

import java.util.List;

import com.levelup.app.models.Venta;
import com.levelup.app.models.dtos.VentaDto;

public interface VentaService {

    Venta createVenta(List<VentaDto> ventasDto);

    List<Venta> findAll();
    
}
