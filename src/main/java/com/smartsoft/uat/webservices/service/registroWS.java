/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.webservices.service;

import com.smartsoft.uat.bo.registroBo;
import com.smartsoft.uat.business.UsuariosBusiness;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Abisai
 */
@Stateless
@Path("registros")
public class registroWS {
    @Inject
    private UsuariosBusiness usuariosbusiness;
    
    
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    /*public String registrar(registroBo registro){
        //System.out.println("recibe="+nombre);
        return usuariosbusiness.registrarWS(registro.getNombre(), registro.getApaterno(), registro.getAmaterno(),
                registro.getCorreo(), registro.getContraseña());
    }*/
    /*public registroBo registrar (registroBo registro){
        System.out.println("recibe="+registro.toString());
        System.out.println("="+usuariosbusiness.registrarWS(registro.getNombre(),registro.getApaterno(),registro.getAmaterno(),registro.getCorreo(),registro.getContraseña()));
        return usuariosbusiness.registrarWS();
    }*/
    public void registrar (registroBo voyaregistrar){
        usuariosbusiness.registrarWS(voyaregistrar.getNombre(),voyaregistrar.getApaterno(),voyaregistrar.getAmaterno(),voyaregistrar.getCorreo(),voyaregistrar.getContraseña(),voyaregistrar.getRol(),voyaregistrar.getUsuario());
    }
    /*public String registrar(@PathParam("nombre") String nombre,@PathParam("apaterno") String apaterno,@PathParam("amaterno") String amaterno,@PathParam("correo") String correo,@PathParam("contraseña") String contraseña){
        return usuariosbusiness.registrarWS(nombre, apaterno, amaterno, correo, contraseña);
    }*/
    
}
