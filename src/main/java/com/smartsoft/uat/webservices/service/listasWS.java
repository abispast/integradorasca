package com.smartsoft.uat.webservices.service;

import com.smartsoft.uat.bo.ListaHBo;
import com.smartsoft.uat.business.HorariosBusiness;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abisai
 */

@Stateless
@Path("listas")
public class listasWS {
    @Inject
    private HorariosBusiness horariosbusiness;
    
    @POST
    @Path("listaHorarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Asynchronous
    public void listaHorario (@Suspended
    final AsyncResponse asyncResponse, final ListaHBo horarios){
        asyncResponse.resume(doListaHorario(horarios));
    }

    private ListaHBo doListaHorario(ListaHBo horarios) {
        return (ListaHBo) horariosbusiness.listaHorariosWS();
    }
}
