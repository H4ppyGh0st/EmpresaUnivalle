package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Integer>{
    
}
