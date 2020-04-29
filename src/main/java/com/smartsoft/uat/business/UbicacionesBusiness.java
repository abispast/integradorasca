/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.UbicacionesDAO;
import com.smartsoft.uat.entity.Ubicaciones;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Abisai
 */
@Stateless
public class UbicacionesBusiness {
    
    @Inject
    private UbicacionesDAO dao;
    
    public Ubicaciones guardar(Ubicaciones entity){
        return dao.saveOrEdit(entity, entity.getIdUbicacion());
    }
}
