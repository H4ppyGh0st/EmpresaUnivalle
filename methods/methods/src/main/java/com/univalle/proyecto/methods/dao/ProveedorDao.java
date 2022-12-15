package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorDao extends JpaRepository<Proveedor, Integer>{
    
}