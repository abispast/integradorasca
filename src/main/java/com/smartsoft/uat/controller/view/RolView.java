/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Rol;
import java.util.List;

/**
 *
 * @author hp
 */
public class RolView {
    
    private Rol entity;
    private List<Rol> listaEntity;

    public Rol getEntity() {
        return entity;
    }

    public void setEntity(Rol entity) {
        this.entity = entity;
    }

    public List<Rol> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Rol> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
