/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.controller.recuperarContraseñaController;
import com.smartsoft.uat.dao.recuperarContraseñaDAO;
import com.smartsoft.uat.entity.ConfiguracionOficinaCorreo;
import com.smartsoft.uat.entity.Usuarios;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Abisai
 */
@Stateless
public class recuperarContraseñaBusiness {
    @Inject
    private recuperarContraseñaDAO dao;
    private recuperarContraseñaController controller;
    
    private static final Logger LOG = Logger.getLogger(recuperarContraseñaBusiness.class.getName());
    
    public List<ConfiguracionOficinaCorreo> obtenerLista(){
        return dao.buscarTodos();
    }
    
    public void enviarCorreo(String destinatario){
        try{
            if (dao.verificarCorreos(destinatario) == null){
                MessageError("Correo electronico no valido");
                LOG.warning("Error, el usuario no es valido");
            }else{
            Properties props = obtenerPropiedadesServidor();
            Authenticator auth = obtenerAutentificacion(props);
            
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setDataHandler(null);
            msg.setFrom(new InternetAddress (props.getProperty("config.from.email"),props.getProperty("config.from.name")));
            msg.setSubject("Recuperacion de Contraseña");
            msg.setText("Estimado Usuario, su peticion de recuperacion de contraseña fue validada correctamente"
                    + " la contraseña para poder ingresar al sistema es: " + verificarCorreos(destinatario).getContrasena()+ "" );
            msg.setRecipients(Message.RecipientType.TO, destinatario);
            Transport.send(msg);
            LOG.info("Mensaje Enviado Exitosamente");
            MessageInfo("Contraseña enviada");
            }} catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(recuperarContraseñaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Authenticator obtenerAutentificacion(Properties props){
        return new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(props.getProperty("config.username"), props.getProperty("config.password"));
            }
        };
    }
    
    private Properties obtenerPropiedadesServidor(){
        Properties props = new Properties();
        for(ConfiguracionOficinaCorreo entity : obtenerLista()){
            props.put(entity.getParametro(), entity.getValor());
        }
        return props;
    }
    
    /*private MimeMessage obtenerRemitentes (MimeMessage msg, List<String> listaDestinatarios){
        for(String destinatario : listaDestinatarios){
            try{
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario,false));
            } catch (MessagingException ex){
                Logger.getLogger(recuperarContraseñaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }*/
    
    public Usuarios verificarCorreos(String destinatario) {
        return  dao.verificarCorreos(destinatario);
    }
    public void MessageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
    
    public void MessageInfo(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
}
