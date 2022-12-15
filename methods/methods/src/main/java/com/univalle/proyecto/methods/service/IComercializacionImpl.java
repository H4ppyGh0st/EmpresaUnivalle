package com.univalle.proyecto.methods.service;

import com.univalle.proyecto.methods.dao.ComercializacionDao;
import com.univalle.proyecto.methods.entity.Comercializacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IComercializacionImpl implements IComercializacionService{

    @Autowired
    ComercializacionDao comercializacionDao;

    @Override
    public Comercializacion crearVenta(Comercializacion comercializacion) {
        return comercializacionDao.save(comercializacion);
    }
    
}
