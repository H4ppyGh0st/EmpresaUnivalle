package com.univalle.proyecto.methods.dao;

import com.univalle.proyecto.methods.entity.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VendedorDao extends JpaRepository<Vendedor, Integer>{

    @Query(value = "SELECT numero_venta FROM vendedor WHERE idvendedor = ?1", nativeQuery = true)
    int obtenerVentas(int id);
    
    @Modifying
    @Query(value = "UPDATE vendedor SET numero_venta = ?1 " +
            "WHERE idvendedor = ?2", nativeQuery = true
            )
    int updateCantidadVentas(int cantidad, int id);
}
