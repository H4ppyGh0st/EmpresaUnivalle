package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Integer>{
    
}
