/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Materias;
import java.util.List;

/**
 *
 * @author hp
 */
public class MateriasView {
    
    private Materias entity;
    private List<Materias> listaEntity;

    public Materias getEntity() {
        return entity;
    }

    public void setEntity(Materias entity) {
        this.entity = entity;
    }

    public List<Materias> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Materias> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
