/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Alumnos;
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
public class AlumnosDAO extends EntitiManager<Alumnos>{
    
    @Inject
    private Persistence persistence;

    public AlumnosDAO() {
        super(Alumnos.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    public List<Alumnos> listaActivos(){
        return persistence.getMysql().createNamedQuery("Alumnos.findAll").getResultList();/////////Nuevo metod de consulta
    }
    public List<Alumnos> obtenerListaAlum() {
        return persistence.getMysql().createNamedQuery("Alumnos.findAll").getResultList();
    }
}
