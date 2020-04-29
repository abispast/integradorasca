/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.bo;

import com.smartsoft.uat.entity.Horarios;

/**
 *
 * @author Abisai
 */
public class ListaHBo {
    private int id;
    private String periodo;
    private String folio;
    private String nombre;
    private int grado;
    private String grupo;
    private String nombreDo;
    private String apellidoPa;
    private String apellidoMa;
    private String salon;
    private String lunesIni;
    private String lunesFin;
    private String martesIni;
    private String martesFin;
    private String miercolesIni;
    private String miercolesFin;
    private String juevesIni;
    private String juevesFin;
    private String viernesIni;
    private String viernesFin;
    
    public ListaHBo(Horarios horario){
        this.id=horario.getId();
        this.folio=horario.getFoliomateria();
        this.nombre=horario.getNombre();
        this.grado=horario.getGrado();
        this.grupo=horario.getGrupo();
        this.nombreDo=horario.getNombreDo();
        this.apellidoPa=horario.getApellidopa();
        this.apellidoMa=horario.getApellidoma();
        this.salon=horario.getSalon();
        this.lunesIni=horario.getLunesInicioString();
        this.lunesFin=horario.getLunesFinString();
        this.martesIni=horario.getMartesInicioString();
        this.martesFin=horario.getMartesFinString();
        this.miercolesIni=horario.getMiercolesInicioString();
        this.miercolesFin=horario.getMiercolesFinString();
        this.juevesIni=horario.getJuevesInicioString();
        this.juevesFin=horario.getJuevesFinString();
        this.viernesIni=horario.getViernesInicioString();
        this.viernesFin=horario.getViernesFinString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombreDo() {
        return nombreDo;
    }

    public void setNombreDo(String nombreDo) {
        this.nombreDo = nombreDo;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getLunesIni() {
        return lunesIni;
    }

    public void setLunesIni(String lunesIni) {
        this.lunesIni = lunesIni;
    }

    public String getLunesFin() {
        return lunesFin;
    }

    public void setLunesFin(String lunesFin) {
        this.lunesFin = lunesFin;
    }

    public String getMartesIni() {
        return martesIni;
    }

    public void setMartesIni(String martesIni) {
        this.martesIni = martesIni;
    }

    public String getMartesFin() {
        return martesFin;
    }

    public void setMartesFin(String martesFin) {
        this.martesFin = martesFin;
    }

    public String getMiercolesIni() {
        return miercolesIni;
    }

    public void setMiercolesIni(String miercolesIni) {
        this.miercolesIni = miercolesIni;
    }

    public String getMiercolesFin() {
        return miercolesFin;
    }

    public void setMiercolesFin(String miercolesFin) {
        this.miercolesFin = miercolesFin;
    }

    public String getJuevesIni() {
        return juevesIni;
    }

    public void setJuevesIni(String juevesIni) {
        this.juevesIni = juevesIni;
    }

    public String getJuevesFin() {
        return juevesFin;
    }

    public void setJuevesFin(String juevesFin) {
        this.juevesFin = juevesFin;
    }

    public String getViernesIni() {
        return viernesIni;
    }

    public void setViernesIni(String viernesIni) {
        this.viernesIni = viernesIni;
    }

    public String getViernesFin() {
        return viernesFin;
    }

    public void setViernesFin(String viernesFin) {
        this.viernesFin = viernesFin;
    }
    
}
