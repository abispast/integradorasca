/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Docentes;
import java.util.List;

/**
 *
 * @author hp
 */
public class DocentesView {
    
    private Docentes entity;
    private List<Docentes> listaEntity;

    public Docentes getEntity() {
        return entity;
    }

    public void setEntity(Docentes entity) {
        this.entity = entity;
    }

    public List<Docentes> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Docentes> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
