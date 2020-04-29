/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.DocentesDAO;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Docentes;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class DocentesBusiness {
    
    @Inject
    private DocentesDAO dao;
    
    public Docentes guardar(Docentes entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Docentes consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Docentes entity, Integer idDocente) {
        entity.setActivo(false);
        dao.deleteLogically(entity);
    }

    public List<Docentes> obtenerListaActivos() {
        return dao.obtenerListaActivos();
    }
    
    public Usuarios existe(String usuario){
        return dao.existe(usuario);
    }
}
