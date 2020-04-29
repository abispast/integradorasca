/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Docentes;
import com.smartsoft.uat.entity.Usuarios;
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
public class DocentesDAO extends EntitiManager<Docentes>{
    
    @Inject
    private Persistence persistence;

    public DocentesDAO() {
        super(Docentes.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    public Usuarios verificarAccesos(String correo, String contrasena) {
        List<Usuarios> lista = persistence.getMysql().createQuery("SELECT c from Usuarios c WHERE c.activo=true and c.correo =:correo and c.contrasena =:contrasena").setParameter("correo", correo).setParameter("contrasena", contrasena).getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);
    }
    
    public Usuarios existe(String correo){
        List<Usuarios> lista = persistence.getMysql().createNamedQuery("Usuarios.existe").setParameter("correo", correo).getResultList();
        return lista.size()>0?lista.get(0):null;
    }
    
    public List<Docentes> listaActivos(){
        return persistence.getMysql().createNamedQuery("Docentes.findAllActivos").getResultList();
    }
     public List<Docentes> obtenerListaActivos() {
        return persistence.getMysql().createNamedQuery("Docentes.findAllActivos").getResultList();
    }
    
}
