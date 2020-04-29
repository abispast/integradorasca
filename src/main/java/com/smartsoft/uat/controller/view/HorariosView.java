/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Horarios;
import java.util.List;

/**
 *
 * @author hp
 */
public class HorariosView {
    
    private Horarios entity;
    private List<Horarios> listaEntity;

    public Horarios getEntity() {
        return entity;
    }

    public void setEntity(Horarios entity) {
        this.entity = entity;
    }

    public List<Horarios> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Horarios> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
