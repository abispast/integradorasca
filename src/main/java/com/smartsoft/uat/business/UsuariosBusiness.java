/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.bo.UsuarioBo;
import com.smartsoft.uat.dao.UsuariosDAO;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Ubicaciones;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class UsuariosBusiness {
    
    @Inject
    private UsuariosDAO dao;
    @Inject 
    private UbicacionesBusiness ubicacionesbusiness;
    
    public Usuarios guardar(Usuarios entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Usuarios consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Usuarios entity, Integer idUsuario) {
        entity.setActivo(false);
        dao.deleteLogically(entity);
    }

    public Usuarios verificarAccesos(String usuario, String contrasena) {
        return  dao.verificarAccesos(usuario, contrasena);
    }

    public List<Usuarios> obtenerListaActivos() {
        return dao.listaActivos();
    }
    
    public Usuarios existe(String usuario){
        return dao.existe(usuario);
    }

    public UsuarioBo verificarAccesosWS(String contraseña, String correo) {
        Usuarios usuario=dao.verificarAccesos(correo, contraseña);
        if(usuario!=null){
            return new UsuarioBo(usuario);
        }else{
            return null;
        }
    }
    
    public String obtenerCordenadasWS(String correo,int id, String lat, String lon) {
        Ubicaciones ubicacion = new Ubicaciones();
        Date date= new Date();
        //SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        //String mytime = java.text.DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());
        //date = format.parse(mytime);
        //String tiempo = Plantilla.format(date);
        //System.out.println("hora:"+tiempo);
        //System.out.println("hora:"+ mytime);
        
        ubicacion.setIdUsuario(id);
        ubicacion.setIdUbicacion(0);
        ubicacion.setFecha(new Date());
        ubicacion.setLatitud(lat);
        ubicacion.setLongitud(lon);
        ubicacion.setHoraRegistro(date);
        
        ubicacionesbusiness.guardar(ubicacion);
        
        System.out.println("id: "+id+", correo:"+correo+", latitud: "+lat+", longitud:"+lon);
        
        return "Exito";
    }
    public void registrarWS(String nombre,String apaterno,String amaterno,String correo,String contraseña,int rol,String usuario){
        Usuarios users = new Usuarios();
        
        users.setId(0);
        users.setNombre(nombre);
        users.setApellidoPaterno(apaterno);
        users.setApellidoMaterno(amaterno);
        users.setCorreo(correo);
        users.setContrasena(contraseña);
        users.setRol(rol);
        users.setTelefono(usuario);
        users.setActivo(true);
        users.setFechaRegistro(new Date());
        
        guardar(users);
        System.out.println("nombre: "+nombre+", correo:"+correo);
        
    }
}
