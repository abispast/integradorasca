/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.AluenroDAO;
import com.smartsoft.uat.dao.JustificantesDAO;
import com.smartsoft.uat.dao.MateriasDAO;
import com.smartsoft.uat.entity.Aluenro;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.entity.Justificantes;
import com.smartsoft.uat.entity.Materias;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class AluenroBusiness {
    
    @Inject
    private AluenroDAO dao;

//    public void eliminar(Aluenro entity, Integer idJust) {
//        
//        dao.deleteLogically(entity);
//    }
    public Aluenro guardar(Aluenro entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public List<Aluenro> obtenerListaInactivos() {
        return dao.listaInactivos();
    }
    
    public Usuarios existe(String usuario){
        return dao.existe(usuario);
    }
    
    public Aluenro existef(String nombrem,String nombreal){
        return dao.existef(nombrem,nombreal);
    }
}
