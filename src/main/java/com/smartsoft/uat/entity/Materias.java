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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodzk
 */
@Entity
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
        ,@NamedQuery(name = "Materias.findAllActivos", query = "SELECT m FROM Materias m WHERE m.activo = true")
    , @NamedQuery(name = "Materias.findById", query = "SELECT m FROM Materias m WHERE m.id = :id")
    , @NamedQuery(name = "Materias.findByFolmat", query = "SELECT m FROM Materias m WHERE m.folmat = :folmat")
    , @NamedQuery(name = "Materias.findByNombremat", query = "SELECT m FROM Materias m WHERE m.nombremat = :nombremat")
    , @NamedQuery(name = "Materias.findByNombredocent", query = "SELECT m FROM Materias m WHERE m.nombredocent = :nombredocent")
    , @NamedQuery(name = "Materias.findByActivo", query = "SELECT m FROM Materias m WHERE m.activo = :activo")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "folmat")
    private String folmat;
    @Size(max = 255)
    @Column(name = "nombremat")
    private String nombremat;
    @Size(max = 255)
    @Column(name = "nombredocent")
    private String nombredocent;
    @Column(name = "activo")
    private Boolean activo;

    public Materias() {
    }

    public Materias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolmat() {
        return folmat;
    }

    public void setFolmat(String folmat) {
        this.folmat = folmat;
    }

    public String getNombremat() {
        return nombremat;
    }

    public void setNombremat(String nombremat) {
        this.nombremat = nombremat;
    }

    public String getNombredocent() {
        return nombredocent;
    }

    public void setNombredocent(String nombredocent) {
        this.nombredocent = nombredocent;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Materias[ id=" + id + " ]";
    }
    
}
