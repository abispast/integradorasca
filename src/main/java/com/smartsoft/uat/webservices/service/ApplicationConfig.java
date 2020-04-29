/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.webservices.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Abisai
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.smartsoft.uat.webservices.service.UsuariosWS.class);
        resources.add(com.smartsoft.uat.webservices.service.listasWS.class);
        resources.add(com.smartsoft.uat.webservices.service.registroWS.class);
    }
}
