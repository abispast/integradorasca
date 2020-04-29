/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.AvisosDAO;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Avisos;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class AvisosBusiness {
    
    @Inject
    private AvisosDAO dao;
    
    public Avisos guardar(Avisos entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Avisos consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Avisos entity, Integer idJust) {
        //entity.setActivo(false);
        dao.deletePhysically(entity);
    }

    public List<Avisos> obtenerListaAvi() {
        return dao.obtenerListaAvi();
    }
    
    public Usuarios existe(String usuario){
        return dao.existe(usuario);
    }
}
