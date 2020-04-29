/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.AluenroBusiness;
import com.smartsoft.uat.business.UsuariosBusiness;

import com.smartsoft.uat.business.MateriasBusiness;
import com.smartsoft.uat.controller.view.AluenroView;
import com.smartsoft.uat.controller.view.UsuariosView;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.controller.view.JustificantesView;
import com.smartsoft.uat.controller.view.MateriasView;
import com.smartsoft.uat.entity.Aluenro;
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


@Named(value = "aluController")
@ViewScoped     //mientras inicies sesion ahí estan los datos
public class AluenroController implements Serializable {

    @Inject
    private SesionController sesion;
    @Inject
    private AluenroBusiness business;

    private AluenroView view;                  //declarar clase, por cada controller existe un view* 

    @PostConstruct
    public void init() {
        view = new AluenroView();
        inactivos();
    }

    public void inactivos() {
        view.setEntity(null);
        view.setListaEntity(business.obtenerListaInactivos());
    }

    public void nuevo() {
        view.setEntity(new Aluenro());
        view.setListaEntity(null);
        view.getEntity().setId(0);
        //view.getEntity().setActivo(true);
        //view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
        //view.getEntity().setFechaRegistro(new Date());
    }

    public void enrolar(String nomM) {
        
        view.setEntity(new Aluenro());
        view.setListaEntity(null);
        view.getEntity().setId(0);
        view.getEntity().setNomal(sesion.getView().getUsuario().getNombreCompleto());
        view.getEntity().setNomma(nomM);
        view.getEntity().setActivo(true);
        guardar();
        
        
    }

    public void editar(Aluenro entity) {
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
            if (existeAlum()) {
                sesion.MessageError("Ya se enrolo a la materia");
                return;
            }
        }
//        crmws.guardarUsuario(view.getEntity());
        business.guardar(view.getEntity());
        sesion.MessageInfo("Enrolamiento Exitoso");
        //mostrarLista();

    }
     
    public boolean existeAlum() {
        if (business.existef(view.getEntity().getNomma(),view.getEntity().getNomal()) != null) {
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
//     public void confirmar(Materias entity) {
//        entity.setActivo(false);
//        business.eliminar(entity, null);
//        sesion.MessageInfo("Docente Validado");
//        mostrarLista();
//    }
//     
//      public void rechazar(Materias entity) {
//        entity.setActivo(false);
//        business.eliminar(entity, null);
//        sesion.MessageInfo("Docente Rechazado");
//        mostrarLista();
//    }
//     
    public AluenroView getView() {
        return view;
    }
}
