package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.UsuariosBusiness;
import com.smartsoft.uat.controller.view.SesionView;
import com.smartsoft.uat.entity.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "sesionController")
@SessionScoped
public class SesionController implements Serializable {

    @Inject
    private UsuariosBusiness usuariosBusiness;

    private SesionView view;

    @PostConstruct
    public void init() {
        view = new SesionView();
        view.setUsuario(new Usuarios());
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        view = null;
        return "/login.xhtml?faces-redirect=true";
    }

    public String iniciarSesion() {
        view.setUsuario(usuariosBusiness.verificarAccesos(view.getUsuario().getCorreo(), view.getUsuario().getContrasena()));
        if (view.getUsuario()!=null  ) {
            if(view.getUsuario().getRol()== 1){
            return "/webapp/catalogos/inicio_coord.xhtml?faces-redirect=true";
            }if (view.getUsuario().getRol()== 2){
                return "/webapp/catalogos/inicio_doc.xhtml?faces-redirect=true";
            }if (view.getUsuario().getRol()== 3){
                return "/webapp/catalogos/inicio_alum.xhtml?faces-redirect=true";
            }if (view.getUsuario().getRol()== 4){
                 return "/webapp/catalogos/inicio_pad.xhtml?faces-redirect=true";
            }else{
                view.setUsuario(new Usuarios());
               MessageError("Verifique sus datos");
            }
        } else {
            view.setUsuario(new Usuarios());
            MessageError("Verifique sus datos");
        }
        return "";
    }

    public SesionView getView() {
        return view;
    }

    public void MessageInfo(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    public void MessageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

}
