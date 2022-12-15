package com.univalle.proyecto.methods.controllers;

import com.univalle.proyecto.methods.service.IBodegaService;
import com.univalle.proyecto.methods.service.IFabricacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bodega")
public class BodegaController {
    
    @Autowired
    private IFabricacionService fabricacionService;

    @Autowired
    private IBodegaService bodegaService;

    @PutMapping("/produccion/cantidad/{cantidad}/id/{id}")
    public int produccionCantidad(@PathVariable("cantidad") int cantidad, @PathVariable("id") int id){
        int result = fabricacionService.disminicionMateriaPrima(cantidad, id);

        if (result != 0) {
            return bodegaService.produccionProductos(cantidad, id);
        } else {
            return 0;
        }
    }
}
