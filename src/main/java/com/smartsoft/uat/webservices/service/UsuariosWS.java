/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.webservices.service;

import com.smartsoft.uat.bo.UsuarioBo;
import com.smartsoft.uat.business.UsuariosBusiness;
import java.text.ParseException;
//import com.smartsoft.uat.entity.Usuarios;
//import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Abisai
 */
@Stateless
@Path("usuarios")
public class UsuariosWS {
    @Inject
    private UsuariosBusiness usuariosbusiness;
    
    @POST
    @Path("inicioSesion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioBo inicioSesion (UsuarioBo usuario){
        System.out.println("usuario= "+ usuario.toString());
        System.out.println("=" + usuariosbusiness.verificarAccesosWS(usuario.getContraseña(), usuario.getCorreo()));
        return usuariosbusiness.verificarAccesosWS(usuario.getContraseña(), usuario.getCorreo());
    }
    
    @GET
    @Path("ubicacion/{correo}/{id}/{lat}/{long}")//lo parametros que recibimos con la url
    public String ubicaciones(@PathParam("correo") String correo,@PathParam("id") int id, @PathParam("lat") String lat, @PathParam("long") String lon) throws ParseException {
      
        return usuariosbusiness.obtenerCordenadasWS(correo, id, lat, lon);
    }
}
