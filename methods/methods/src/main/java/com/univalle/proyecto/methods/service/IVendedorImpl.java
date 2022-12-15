package com.univalle.proyecto.methods.service;

import javax.transaction.Transactional;

import com.univalle.proyecto.methods.dao.VendedorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IVendedorImpl implements IVendedorService{

    @Autowired
    private VendedorDao vendedorDao;

    @Override
    public int aumentarVenta(int cantidad, int id) {
        int cantidad2= cantidad + vendedorDao.obtenerVentas(id);
        return vendedorDao.updateCantidadVentas(cantidad2, id);
    }
    
}
