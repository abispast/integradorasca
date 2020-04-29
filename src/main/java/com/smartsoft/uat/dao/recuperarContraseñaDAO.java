/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.ConfiguracionOficinaCorreo;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Abisai
 */
@Stateless
    
public class recuperarContraseñaDAO extends EntitiManager<ConfiguracionOficinaCorreo>{
        
    @Inject
    private Persistence persistence;
        
    public recuperarContraseñaDAO(){
        super (ConfiguracionOficinaCorreo.class);
    }
    public List<ConfiguracionOficinaCorreo> buscarTodos() {
        return persistence.getMysql().createNamedQuery("ConfiguracionOficinaCorreo.findAll").getResultList();
    }
        
    @Override
    protected EntityManager getEntityManager(){
        return persistence.getMysql();
    }
    
    public Usuarios verificarCorreos(String destinatario) {
        List<Usuarios> lista = persistence.getMysql().createQuery("SELECT c from Usuarios c WHERE c.activo=true and c.correo =:correo").setParameter("correo", destinatario).getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);
    }
}
