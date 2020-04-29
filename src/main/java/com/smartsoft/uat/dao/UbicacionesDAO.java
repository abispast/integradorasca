/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Ubicaciones;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Abisai
 */
@Stateless
public class UbicacionesDAO extends EntitiManager<Ubicaciones>{
    
    @Inject
    private Persistence persistence;
    
     public UbicacionesDAO() {
        super(Ubicaciones.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    
}
