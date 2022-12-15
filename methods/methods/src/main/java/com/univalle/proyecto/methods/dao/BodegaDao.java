package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Bodega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BodegaDao extends JpaRepository<Bodega, Integer>{
    
    @Query(value = "SELECT cantidad FROM bodega WHERE idproducto_bod = ?1", nativeQuery = true)
    int obtenerCantidad(int id);
    
    @Modifying
    @Query(value = "UPDATE bodega SET cantidad = ?1 " +
            "WHERE idproducto_bod = ?2", nativeQuery = true
            )
    int updateCantidadBodega(int cantidad, int id);
}
