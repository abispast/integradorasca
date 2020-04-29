/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Horarios;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author hp
 */
@Stateless
public class HorariosDAO extends EntitiManager<Horarios>{
    
    @Inject
    private Persistence persistence;

    public HorariosDAO() {
        super(Horarios.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    public List<Horarios> listaActivos(){
        return persistence.getMysql().createNamedQuery("Horarios.findAll").getResultList();/////////Nuevo metod de consulta
    }
    public List<Horarios> obtenerListaHor() {
        return persistence.getMysql().createNamedQuery("Horarios.findAll").getResultList();
    }
}
