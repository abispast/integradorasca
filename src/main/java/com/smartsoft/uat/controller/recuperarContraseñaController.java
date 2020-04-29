/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.recuperarContraseñaBusiness;
import com.smartsoft.uat.controller.view.recuperarContraseñaView;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Abisai
 */

@Named(value="recuperarController")
@ViewScoped
public class recuperarContraseñaController implements Serializable {
    @Inject
    private recuperarContraseñaBusiness business;
    private recuperarContraseñaView view;
    
    @PostConstruct
    public void init(){
        view = new recuperarContraseñaView();
    }
    
    public recuperarContraseñaView getView(){
        return view;
    }
    public void enviarCorreo(){
        business.enviarCorreo(view.getDestinatario());
    }
}
