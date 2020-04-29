/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.csvreader.CsvReader;
import com.smartsoft.uat.business.HorariosBusiness;
import com.smartsoft.uat.controller.view.HorariosView;
import com.smartsoft.uat.controller.view.MateriasView;
import com.smartsoft.uat.entity.Horarios;
import com.smartsoft.uat.entity.Materias;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

@Named(value = "horariosController")
@ViewScoped
public class HorariosController implements Serializable{
   
    @Inject
    private SesionController sesion;
    @Inject
    private HorariosBusiness business;
    
    private HorariosView view;
  
    
    @PostConstruct
    public void init() {
        view = new HorariosView();
        mostrarLista();
       
    }
  
    
    public void mostrarLista(){
        view.setEntity(null);
            view.setListaEntity(business.obtenerListaHor());
    }
    
    public void nuevo() {
        view.setEntity(new Horarios());
        view.setListaEntity(null);
        view.getEntity().setId(0);
    }
   
    public void editar(Horarios entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    public void eliminar(Horarios entity) {
       // entity.setActivo(false);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }

    public void guardar() {
        business.guardar(view.getEntity());
        sesion.MessageInfo("Registro exitoso");
        mostrarLista();
    }

    
    public HorariosView getView() {
        return view;
    }
    public void  cargarHorarios(FileUploadEvent event) throws IOException{
        UploadedFile f = event.getFile();
        
        Reader br = new BufferedReader (new InputStreamReader (f.getInputstream()));
        CsvReader csv = new CsvReader(br);
        csv.readHeaders();
        
        try{
            while(csv.readRecord()){
                Horarios p = new Horarios();
                DateFormat dateFormat= new SimpleDateFormat("HH:mm");
                p.setId(0);
                p.setActivo(1);
                p.setPeriodo(csv.get("periodo"));
                p.setFoliomateria(csv.get("foliomateria"));
                p.setNombre(csv.get("nombre"));
                p.setGrado((Integer.parseInt(csv.get("grado"))));
                p.setGrupo(csv.get("grupo"));
                p.setNombreDo(csv.get("nombreDo"));
                p.setApellidopa(csv.get("apellidopa"));
                p.setApellidoma(csv.get("apellidoma")); 
                p.setSalon(csv.get("salon"));
                p.setLunesInicio(dateFormat.parse(csv.get("lunes_inicio")));
                p.setLunesFin(dateFormat.parse(csv.get("lunes_fin")));
                p.setMartesInicio(dateFormat.parse(csv.get("martes_inicio")));
                p.setMartesFin(dateFormat.parse(csv.get("martes_fin")));
                p.setMiercolesInicio(dateFormat.parse(csv.get("miercoles_inicio")));
                p.setMiercolesFin(dateFormat.parse(csv.get("miercoles_fin")));
                p.setJuevesInicio(dateFormat.parse(csv.get("jueves_inicio")));
                p.setJuevesFin(dateFormat.parse(csv.get("jueves_fin")));
                p.setViernesInicio(dateFormat.parse(csv.get("viernes_inicio")));
                p.setViernesFin(dateFormat.parse(csv.get("viernes_fin")));
                
                business.guardar(p);
               
               sesion.MessageInfo("Registro exitoso");
            } 
        }catch(Exception e){
                    sesion.MessageInfo("no se pudo");
                    e.printStackTrace();
            }
        finally{
            if(null!=br){
                br.close();
            }
        }
        
    }
}
 