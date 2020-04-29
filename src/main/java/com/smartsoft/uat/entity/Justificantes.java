/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abisai
 */
@Entity
@Table(name = "justificantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Justificantes.findAll", query = "SELECT j FROM Justificantes j")
    , @NamedQuery(name = "Justificantes.findById", query = "SELECT j FROM Justificantes j WHERE j.id = :id")
    , @NamedQuery(name = "Justificantes.findByMatricula", query = "SELECT j FROM Justificantes j WHERE j.matricula = :matricula")
    , @NamedQuery(name = "Justificantes.findByNombre", query = "SELECT j FROM Justificantes j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Justificantes.findByMotivo", query = "SELECT j FROM Justificantes j WHERE j.motivo = :motivo")
    , @NamedQuery(name = "Justificantes.findByFecha", query = "SELECT j FROM Justificantes j WHERE j.fecha = :fecha")})
public class Justificantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Justificantes() {
    }

    public Justificantes(Integer id) {
        this.id = id;
    }

    public Justificantes(Integer id, int matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Justificantes)) {
            return false;
        }
        Justificantes other = (Justificantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Justificantes[ id=" + id + " ]";
    }
    
}
