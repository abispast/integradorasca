/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;


import com.smartsoft.uat.business.OficinaCorreoBussines;
import com.smartsoft.uat.controller.view.CorreoView;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * 
 */
@Named(value = "correoController")
@ViewScoped
public class CorreoController implements Serializable{
    @Inject
    OficinaCorreoBussines business;
    private CorreoView view;

    @PostConstruct
    public void init() {
        view = new CorreoView();
    }

    public CorreoView getView() {
        return view;
    }
    
    
    public void enviarCorreo(){
        business.enviarCorreo(view.getAsunto(),view.getDestinatario(),view.getContenido());
    }
}
