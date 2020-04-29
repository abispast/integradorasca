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
public class UsuarioBo {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private int rol;
    
    public UsuarioBo(){
    
    }
    public UsuarioBo(Usuarios usuario) {
        this.id=usuario.getId();
        this.correo=usuario.getCorreo();
        this.nombre=usuario.getNombreCompleto();
        this.rol=usuario.getRol();
        //this.nombre = nombre;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    @Override
    public String toString() {
        return "UsuarioBo{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", rol=" + rol +"}";
    }
}
