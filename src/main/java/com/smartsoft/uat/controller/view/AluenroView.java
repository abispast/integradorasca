/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Aluenro;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Materias;
import java.util.List;

/**
 *
 * @author hp
 */
public class AluenroView {
    
    private Aluenro entity;
    private List<Aluenro> listaEntity;

    public Aluenro getEntity() {
        return entity;
    }

    public void setEntity(Aluenro entity) {
        this.entity = entity;
    }

    public List<Aluenro> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Aluenro> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
}
