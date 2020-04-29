/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;


import com.smartsoft.uat.business.UsuariosBusiness;
import com.smartsoft.uat.controller.view.UsuariosView;
import com.smartsoft.uat.entity.Usuarios;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named(value = "usuariosController")
@ViewScoped     //mientras inicies sesion ahí estan los datos
public class UsuariosController implements Serializable{
    
    @Inject
    private SesionController sesion;
    @Inject
    private UsuariosBusiness business;
     
    private UsuariosView view;   //declarar clase, por cada controller existe un view* 
    
    
    @PostConstruct
    public void init() {
        view = new UsuariosView();
        mostrarLista();
    }
    
    public void mostrarLista(){
        view.setEntity(null);
        view.setListaEntity(business.obtenerListaActivos());
    }
   
    
    
    
    public void nuevo() {
        view.setEntity(new Usuarios());
        view.setListaEntity(null);
        view.getEntity().setId(0);
        view.getEntity().setActivo(true);
        view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
        view.getEntity().setFechaRegistro(new Date());
    }

    public void editar(Usuarios entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    public void eliminar(Usuarios entity) {
        entity.setActivo(false);
        entity.setIdElimino(sesion.getView().getUsuario().getId());
        entity.setFechaElimino(new Date());
        business.eliminar(entity, null);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }

    public void guardar() {
        if (view.getEntity().getId() == null || view.getEntity().getId() == 0) {
            if (existeUsuario()) {
                sesion.MessageError("El correo ya existe");
                return;
            }
        }
//        crmws.guardarUsuario(view.getEntity());
        business.guardar(view.getEntity());
        sesion.MessageInfo("Registro exitoso");
        mostrarLista();
    }

    public boolean existeUsuario() {
        if (business.existe(view.getEntity().getCorreo()) != null) {
            return true;
        }
        return false;
    }
    
    public UsuariosView getView() {
        return view;
    }
         
}
