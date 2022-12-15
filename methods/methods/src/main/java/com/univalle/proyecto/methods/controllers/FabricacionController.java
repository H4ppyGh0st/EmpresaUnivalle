package com.univalle.proyecto.methods.controllers;

import javax.persistence.TransactionRequiredException;

import com.univalle.proyecto.methods.service.IFabricacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fabricacion")
public class FabricacionController {

    @Autowired
    private IFabricacionService fabricacionService;

    @PutMapping("/compra/cantidad/{cantidad}/id/{id}")
    public int compraCantidad(@PathVariable("cantidad") int cantidad, @PathVariable("id") int id) throws TransactionRequiredException{
        return fabricacionService.compraMateriaPrima(cantidad, id);
    }

    
}
