/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.UsuariosBusiness;
import com.smartsoft.uat.business.DocentesBusiness;
import com.smartsoft.uat.controller.view.UsuariosView;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.controller.view.DocentesView;
import com.smartsoft.uat.entity.Docentes;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
;
import javax.inject.Inject;
/**
 *
 * @author hp
 */
@Named(value = "docentesController")
@ViewScoped     //mientras inicies sesion ahí estan los datos
public class DocentesController implements Serializable{
    
    @Inject
    private SesionController sesion;
    @Inject
    private DocentesBusiness business;
    
    private DocentesView view;                  //declarar clase, por cada controller existe un view* 
    
    @PostConstruct
    public void init() {
        view = new DocentesView();
        mostrarLista();
    }
    
    public void mostrarLista(){
        view.setEntity(null);
        view.setListaEntity(business.obtenerListaActivos());
    }
    
    public void nuevo() {
        view.setEntity(new Docentes());
        view.setListaEntity(null);
        view.getEntity().setActivo(true);
        //view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
        //view.getEntity().setFechaRegistro(new Date());
    }

    public void editar(Docentes entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    public void eliminar(Docentes entity) {
        entity.setActivo(false);
        //entity.setIdElimino(sesion.getView().getUsuario().getId());
        //entity.setFechaElimino(new Date());
        business.eliminar(entity, null);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }

    public void guardar() {
        /*if (view.getEntity().getId()== null || view.getEntity().getId() == 0) {
            if (existeDocente()) {
                sesion.MessageError("El docente ya existe");
                return;
            }
        }*/
//        crmws.guardarUsuario(view.getEntity());
        business.guardar(view.getEntity());
        sesion.MessageInfo("Registro exitoso");
        mostrarLista();
    }

    public boolean existeDocente() {
        if (business.existe(view.getEntity().getNombre()) != null) {
            return true;
        }
        return false;
    }
    public void confirmar(Docentes entity) {
        entity.setActivo(false);
        business.eliminar(entity, null);
        sesion.MessageInfo("Docente Validado");
        mostrarLista();
    }
    
    public void rechazar(Docentes entity) {
        entity.setActivo(false);
        business.eliminar(entity, null);
        sesion.MessageInfo("Solicitud Rechazada");
        mostrarLista();
    }
    
    public void enrolarDocente(Docentes entity,String materia) {
        entity.setActivo(false);
        entity.setMateria(materia);
        business.eliminar(entity, null);
        sesion.MessageInfo("Docente Validado");
        mostrarLista();
    }
    
    public DocentesView getView() {
        return view;
    }
}
