/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import java.util.List;

/**
 *
 * @author hp
 */
public class UsuariosView {
    
    private Usuarios entity;
    private List<Usuarios> listaEntity;

    public Usuarios getEntity() {
        return entity;
    }

    public void setEntity(Usuarios entity) {
        this.entity = entity;
    }

    public List<Usuarios> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Usuarios> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
