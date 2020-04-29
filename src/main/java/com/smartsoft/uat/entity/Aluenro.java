/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodzk
 */
@Entity
@Table(name = "aluenro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluenro.findAll", query = "SELECT a FROM Aluenro a")
    ,@NamedQuery(name = "Aluenro.findAllActivos", query = "SELECT a FROM Aluenro a WHERE a.activo = false")
    ,@NamedQuery(name = "Aluenro.findAllInactivos", query = "SELECT a FROM Aluenro a WHERE a.activo != true")
    , @NamedQuery(name = "Aluenro.findById", query = "SELECT a FROM Aluenro a WHERE a.id = :id")
    , @NamedQuery(name = "Aluenro.findByActivo", query = "SELECT a FROM Aluenro a WHERE a.activo = :activo")
    , @NamedQuery(name = "Aluenro.findByNomma", query = "SELECT a FROM Aluenro a WHERE a.nomma = :nomma")
    , @NamedQuery(name = "Aluenro.findByNomal", query = "SELECT a FROM Aluenro a WHERE a.nomal = :nomal")})
public class Aluenro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 255)
    @Column(name = "nomma")
    private String nomma;
    @Size(max = 255)
    @Column(name = "nomal")
    private String nomal;

    public Aluenro() {
    }

    public Aluenro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNomma() {
        return nomma;
    }

    public void setNomma(String nomma) {
        this.nomma = nomma;
    }

    public String getNomal() {
        return nomal;
    }

    public void setNomal(String nomal) {
        this.nomal = nomal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluenro)) {
            return false;
        }
        Aluenro other = (Aluenro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Aluenro[ id=" + id + " ]";
    }
    
}
