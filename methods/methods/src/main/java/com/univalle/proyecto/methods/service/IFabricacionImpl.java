package com.univalle.proyecto.methods.service;

import java.util.List;

import com.univalle.proyecto.methods.dao.FabricacionDao;
import com.univalle.proyecto.methods.entity.Fabricacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IFabricacionImpl implements IFabricacionService{

    @Autowired
    private FabricacionDao fabricacionDao;

    @Override
    public int compraMateriaPrima(int cantidad, int id) {
        int cantidad2= cantidad + fabricacionDao.obtenerCantidad(id);
        return fabricacionDao.updateMateriaPrima(cantidad2, id);
    }

    @Override
    public int disminicionMateriaPrima(int cantidad, int id) {

        List<Fabricacion> cantidad2 = fabricacionDao.obtenerCantidadDeTodosLosIngredientes(id);

        boolean correct = true;

        for (int i = 0; i < cantidad2.size(); i++) {
            int cantidad3 = cantidad2.get(i).getCantidad() - cantidad;
            
            if (cantidad >= 0) {
                cantidad2.get(i).setCantidad(cantidad3);
            } else {
                correct = false;
            }
        }

        if (correct){
            for (int i = 0; i < cantidad2.size(); i++) {
                fabricacionDao.updateMateriaPrimaPorProduccion(cantidad2.get(i).getCantidad(), cantidad2.get(i).getId());
            }

            return 1;

        } else {

        return 0;
        }

    }
    
}
