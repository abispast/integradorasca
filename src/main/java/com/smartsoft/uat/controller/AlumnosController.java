/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.csvreader.CsvReader;
import com.smartsoft.uat.business.AlumnosBusiness;
import com.smartsoft.uat.controller.view.AlumnosView;
import com.smartsoft.uat.entity.Alumnos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author hp
 */

@Named(value = "SaludController")
@ViewScoped
public class AlumnosController implements Serializable{
    
    @Inject
    private SesionController sesion;
    @Inject
    private AlumnosBusiness business;
    
    private AlumnosView view;
    
    @PostConstruct
    public void init() {
        view = new AlumnosView();
        mostrarLista();
    }
    
    public void mostrarLista(){
        view.setEntity(null);
            view.setListaEntity(business.obtenerListaAlum());
    }
    
    public void nuevo() {
        view.setEntity(new Alumnos());
        view.setListaEntity(null);
        view.getEntity().setId(0);
    }

    public void editar(Alumnos entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    public void eliminar(Alumnos entity) {
       // entity.setActivo(false);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }

    public void guardar() {
        business.guardar(view.getEntity());
        sesion.MessageInfo("Registro exitoso");
        mostrarLista();
    }

    
    public AlumnosView getView() {
        return view;
    }
    public void  cargarClientes(FileUploadEvent event) throws IOException{
        UploadedFile f = event.getFile();
        
        Reader br = new BufferedReader (new InputStreamReader (f.getInputstream()));
        CsvReader csv = new CsvReader(br);
        csv.readHeaders();
        
        try{
            while(csv.readRecord()){
                Alumnos p = new Alumnos();
                p.setId(0);
                p.setMatricula((Integer.parseInt(csv.get("matricula"))));
                p.setNombreCompleto(csv.get("nombre_completo"));
                p.setGrado(Integer.parseInt(csv.get("grado")));
                p.setProgramaEducativo(csv.get("programa_educativo"));
               
                business.guardar(p);
               
               sesion.MessageInfo("Registro exitoso");
            } 
        }catch(Exception e){
                    sesion.MessageInfo("no se pudo");
            }
        finally{
            if(null!=br){
                br.close();
            }
        }
        
    }
    
    ////////Probando
}
 