/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.ConfiguracionOficinaCorreo;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Smart
 */
@Stateless

public class ConfiguracionOficinaCorreoDAO extends EntitiManager<ConfiguracionOficinaCorreo>{

    @Inject
    private Persistence persistence;

    public ConfiguracionOficinaCorreoDAO() {
          super(ConfiguracionOficinaCorreo.class);
    }
 public List<ConfiguracionOficinaCorreo> buscarTodos() {
        return persistence.getMysql().createNamedQuery("ConfiguracionOficinaCorreo.findAll").getResultList();
    }
    
@Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
}
