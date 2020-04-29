/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.JustificantesDAO;
import com.smartsoft.uat.dao.MateriasDAO;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Justificantes;
import com.smartsoft.uat.entity.Materias;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class MateriasBusiness {
    
    @Inject
    private MateriasDAO dao;

    public void eliminar(Materias entity, Integer idJust) {
        
        dao.deleteLogically(entity);
    }
    public Materias guardar(Materias entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public List<Materias> obtenerListaMat() {
        return dao.obtenerListaMat();
    }
    
    public Usuarios existe(String usuario){
        return dao.existe(usuario);
    }
    
    public Materias existef(String folmat){
        return dao.existef(folmat);
    }
}
