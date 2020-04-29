/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Puntos;
import java.util.List;

/**
 *
 * @author hp
 */
public class Mapa {
    
    private Puntos entity;
    private List<Puntos> listaEntity;

    public Puntos getEntity() {
        return entity;
    }

    public void setEntity(Puntos entity) {
        this.entity = entity;
    }

    public List<Puntos> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Puntos> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
