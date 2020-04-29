/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.AlumnosDAO;
import com.smartsoft.uat.entity.Alumnos;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class AlumnosBusiness {
    
    @Inject
    private AlumnosDAO dao;
    
    public Alumnos guardar(Alumnos entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Alumnos consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Alumnos entity, Integer idUsuario) {
       // entity.setActivo(false);
        dao.deleteLogically(entity);
    }

    public List<Alumnos> obtenerListaAlum() {
        return dao.obtenerListaAlum();
    }
}
