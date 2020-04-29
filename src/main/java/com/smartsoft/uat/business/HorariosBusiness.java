/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.bo.ListaHBo;
import com.smartsoft.uat.dao.HorariosDAO;
import com.smartsoft.uat.entity.Horarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class HorariosBusiness {
    
    @Inject
    private HorariosDAO dao;
    
    public Horarios guardar(Horarios entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Horarios consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Horarios entity, Integer idUsuario) {
       // entity.setActivo(false);
        dao.deleteLogically(entity);
    }

    public List<Horarios> obtenerListaHor() {
        return dao.obtenerListaHor();
    }
    
    public List<Horarios> listaHorariosWS(){
        return dao.obtenerListaHor();
    }
}
