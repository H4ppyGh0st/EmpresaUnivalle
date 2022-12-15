package com.univalle.proyecto.methods.controllers;

import com.univalle.proyecto.methods.entity.Comercializacion;
import com.univalle.proyecto.methods.service.IBodegaService;
import com.univalle.proyecto.methods.service.IComercializacionService;
import com.univalle.proyecto.methods.service.IVendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comercializacion")
public class ComercializacionController {

    @Autowired
    private IComercializacionService comercializacionService;

    @Autowired
    private IBodegaService bodegaService;

    @Autowired
    private IVendedorService vendedorService;

    @PostMapping("/venta")
    public Comercializacion compraCantidad(@RequestBody Comercializacion comercializacion){

        bodegaService.diminucionProductos(comercializacion.getCantidadCom(), comercializacion.getIdProductoCom());

        vendedorService.aumentarVenta(1, comercializacion.getVendedor());

        comercializacion.setComisionVenta((int) (comercializacion.getPrecioCom() / 100) * comercializacion.getComisionVenta());

        return comercializacionService.crearVenta(comercializacion);
    }
}
