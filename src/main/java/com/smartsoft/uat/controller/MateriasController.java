/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.UsuariosBusiness;

import com.smartsoft.uat.business.MateriasBusiness;
import com.smartsoft.uat.controller.view.UsuariosView;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.controller.view.JustificantesView;
import com.smartsoft.uat.controller.view.MateriasView;
import com.smartsoft.uat.entity.Docentes;
import com.smartsoft.uat.entity.Justificantes;
import com.smartsoft.uat.entity.Materias;
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


@Named(value = "matController")
@ViewScoped     //mientras inicies sesion ahí estan los datos
public class MateriasController implements Serializable {

    @Inject
    private SesionController sesion;
    @Inject
    private MateriasBusiness business;

    private MateriasView view;                  //declarar clase, por cada controller existe un view* 

    @PostConstruct
    public void init() {
        view = new MateriasView();
        mostrarLista();
    }

    public void mostrarLista() {
        view.setEntity(null);
        view.setListaEntity(business.obtenerListaMat());
    }

    public void nuevo() {
        view.setEntity(new Materias());
        view.setListaEntity(null);
        view.getEntity().setId(0);
        //view.getEntity().setActivo(true);
        //view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
        //view.getEntity().setFechaRegistro(new Date());
    }

    public void enrolar(String foliom, String nomM) {
        
        view.setEntity(new Materias());
        view.setListaEntity(null);
        view.getEntity().setId(0);
        view.getEntity().setFolmat(foliom);
        view.getEntity().setNombremat(nomM);
        view.getEntity().setActivo(true);
        view.getEntity().setNombredocent(sesion.getView().getUsuario().getNombreCompleto());
        //view.getEntity().setFechaRegistro(new Date());
        guardar();
        
        
    }

    public void editar(Materias entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    /*public void eliminar(Justificantes entity) {
        //entity.setActivo(false);
        //entity.setIdElimino(sesion.getView().getUsuario().getId());
        //entity.setFechaElimino(new Date());
        business.eliminar(entity, null);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }*/
    
    public void guardar() {
        if (view.getEntity().getId()== null || view.getEntity().getId() == 0) {
            if (existeMateria()) {
                sesion.MessageError("Ya se enrolo a la materia");
                return;
            }
        }
//        crmws.guardarUsuario(view.getEntity());
        business.guardar(view.getEntity());
        sesion.MessageInfo("Registro exitoso");
        //mostrarLista();

    }
     
    public boolean existeMateria() {
        if (business.existef(view.getEntity().getFolmat()) != null) {
            return true;
        }
        return false;
    }
    /*public boolean existeDocente() {
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
     */
     public void confirmar(Materias entity) {
        entity.setActivo(false);
        business.eliminar(entity, null);
        sesion.MessageInfo("Docente Validado");
        mostrarLista();
    }
     
      public void rechazar(Materias entity) {
        entity.setActivo(false);
        business.eliminar(entity, null);
        sesion.MessageInfo("Docente Rechazado");
        mostrarLista();
    }
//     
    public MateriasView getView() {
        return view;
    }
}
