/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Avisos;
import java.util.List;

/**
 *
 * @author hp
 */
public class AvisosView {
    
    private Avisos entity;
    private List<Avisos> listaEntity;

    public Avisos getEntity() {
        return entity;
    }

    public void setEntity(Avisos entity) {
        this.entity = entity;
    }

    public List<Avisos> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Avisos> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
