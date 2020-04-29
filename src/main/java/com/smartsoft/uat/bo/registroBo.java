/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.bo;

import com.smartsoft.uat.entity.Usuarios;

/**
 *
 * @author Abisai
 */
public class registroBo {
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String correo;
    private String contraseña;
    private int rol;
    private String usuario;
    
    
    public registroBo(){
        
    }

    public registroBo(String nombre, String apaterno, String amaterno, String correo, String contraseña, int rol, String usuario) {
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.usuario = usuario;
        
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
       
    @Override
    public String toString(){
        return "registroBo{"+"nombre="+nombre+", apaterno="+apaterno+", amaterno="+amaterno+""
                + ", coreo="+correo+", contraseña="+contraseña+", usuario="+usuario+", rol="+rol+'}';
    }
}
