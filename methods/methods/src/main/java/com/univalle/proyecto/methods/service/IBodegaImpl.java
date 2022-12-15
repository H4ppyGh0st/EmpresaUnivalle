package com.univalle.proyecto.methods.service;

import com.univalle.proyecto.methods.dao.BodegaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IBodegaImpl implements IBodegaService{

    @Autowired
    private BodegaDao bodegaDao;

    @Override
    public int produccionProductos(int cantidad, int id) {
        int cantidad2= cantidad + bodegaDao.obtenerCantidad(id);
        return bodegaDao.updateCantidadBodega(cantidad2, id);
    }

    @Override
    public int diminucionProductos(int cantidad, int id) {
        int cantidad2=  bodegaDao.obtenerCantidad(id) - cantidad;
        return bodegaDao.updateCantidadBodega(cantidad2, id);
    }
    

}
