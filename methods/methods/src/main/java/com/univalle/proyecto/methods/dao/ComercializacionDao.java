package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Comercializacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComercializacionDao extends JpaRepository<Comercializacion, Integer>{
    
}
