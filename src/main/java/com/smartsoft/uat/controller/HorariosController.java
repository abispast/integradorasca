/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.csvreader.CsvReader;
import com.smartsoft.uat.business.HorariosBusiness;
import com.smartsoft.uat.controller.view.AreaView;
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
    
    private AreaView areaview;
  
    
    @PostConstruct
    public void init() {
        view = new HorariosView();
        mostrarLista();
       
    }
  
    
    public void mostrarLista(){
        view.setEntity(null);
        view.setListaEntity(business.obtenerListaActivos());
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
        entity.setActivo(false);
        business.eliminar(entity, null);
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
                p.setActivo(true);
                p.setPeriodo(csv.get("periodo"));
                p.setFoliomateria(csv.get("foliomateria"));
                p.setNombre(csv.get("nombre"));
                p.setGrado((Integer.parseInt(csv.get("grado"))));
                p.setGrupo(csv.get("grupo"));
                p.setNombreDo(csv.get("nombreDo"));
                p.setApellidopa(csv.get("apellidopa"));
                p.setApellidoma(csv.get("apellidoma")); 
                p.setSalon(csv.get("salon"));
                
                if(csv.get("lunes_inicio")!= ""){
                    p.setLunesInicio(dateFormat.parse(csv.get("lunes_inicio")));
                }else{
                    p.setLunesInicio(null);
                }   
                if(csv.get("lunes_fin")!= ""){
                    p.setLunesFin(dateFormat.parse(csv.get("lunes_fin")));
                }else{
                    p.setLunesFin(null);
                }   
                if(csv.get("martes_inicio")!= ""){
                    p.setMartesInicio(dateFormat.parse(csv.get("martes_inicio")));
                }else{
                    p.setMartesInicio(null);
                }   
                if(csv.get("martes_fin")!= ""){
                    p.setMartesFin(dateFormat.parse(csv.get("martes_fin")));
                }else{
                    p.setMartesFin(null);
                }   
                if(csv.get("miercoles_inicio")!= ""){
                    p.setMiercolesInicio(dateFormat.parse(csv.get("miercoles_inicio")));
                }else{
                    p.setMiercolesInicio(null);
                }   
                if(csv.get("miercoles_fin")!= ""){
                    p.setMiercolesFin(dateFormat.parse(csv.get("miercoles_fin")));
                }else{
                    p.setMiercolesFin(null);
                }   
                if(csv.get("jueves_inicio")!= ""){
                    p.setJuevesInicio(dateFormat.parse(csv.get("jueves_inicio")));
                }else{
                    p.setJuevesInicio(null);
                }   
                if(csv.get("jueves_fin")!= ""){
                    p.setJuevesFin(dateFormat.parse(csv.get("jueves_fin")));
                }else{
                    p.setJuevesFin(null);
                }
                if(csv.get("viernes_fin")!= ""){
                    p.setViernesInicio(dateFormat.parse(csv.get("viernes_inicio")));
                }else{
                    p.setViernesInicio(null);
                }   
                if(csv.get("viernes_fin")!= ""){
                     p.setViernesFin(dateFormat.parse(csv.get("viernes_fin")));
                }else{
                    p.setViernesFin(null);
                }  
                
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
 