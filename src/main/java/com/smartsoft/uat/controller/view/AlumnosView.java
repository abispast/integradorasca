/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Alumnos;
import java.util.List;

/**
 *
 * @author hp
 */
public class AlumnosView {
    
    private Alumnos entity;
    private List<Alumnos> listaEntity;

    public Alumnos getEntity() {
        return entity;
    }

    public void setEntity(Alumnos entity) {
        this.entity = entity;
    }

    public List<Alumnos> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Alumnos> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
