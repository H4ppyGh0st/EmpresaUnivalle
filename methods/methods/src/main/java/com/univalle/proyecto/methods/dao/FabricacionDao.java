package com.univalle.proyecto.methods.dao;

import java.util.List;

import com.univalle.proyecto.methods.entity.Fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FabricacionDao extends JpaRepository<Fabricacion, Integer>{

    @Query(value = "SELECT cantidad FROM fabricacion WHERE id = ?1", nativeQuery = true)
    int obtenerCantidad(int id);

    @Query(value = "SELECT * FROM fabricacion WHERE idproducto_fab = ?1", nativeQuery = true)
    List<Fabricacion> obtenerCantidadDeTodosLosIngredientes(int id);
    
    @Modifying
    @Query(value = "UPDATE fabricacion SET cantidad = ?1 " +
            "WHERE idproducto_fab = ?2", nativeQuery = true
            )
    int updateMateriaPrima(int cantidad, int id);

    @Modifying
    @Query(value = "UPDATE fabricacion SET cantidad = ?1 " +
            "WHERE id = ?2", nativeQuery = true
            )
    int updateMateriaPrimaPorProduccion(int cantidad, int id);
}
