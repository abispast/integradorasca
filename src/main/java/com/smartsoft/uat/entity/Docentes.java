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
 * @author Abisai
 */
@Entity
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d")
    , @NamedQuery(name = "Docentes.findById", query = "SELECT d FROM Docentes d WHERE d.id = :id")
    , @NamedQuery(name = "Docentes.findByActivo", query = "SELECT d FROM Docentes d WHERE d.activo = :activo")
    , @NamedQuery(name = "Docentes.findAllActivos", query = "SELECT u FROM Docentes u WHERE u.activo = true")
    , @NamedQuery(name = "Docentes.findByTitulo", query = "SELECT d FROM Docentes d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Docentes.findByNombre", query = "SELECT d FROM Docentes d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Docentes.findByApellidopaterno", query = "SELECT d FROM Docentes d WHERE d.apellidopaterno = :apellidopaterno")
    , @NamedQuery(name = "Docentes.findByApellidomaterno", query = "SELECT d FROM Docentes d WHERE d.apellidomaterno = :apellidomaterno")
    , @NamedQuery(name = "Docentes.findByMateria", query = "SELECT d FROM Docentes d WHERE d.materia = :materia")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 15)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellidopaterno")
    private String apellidopaterno;
    @Size(max = 255)
    @Column(name = "apellidomaterno")
    private String apellidomaterno;
    @Size(max = 255)
    @Column(name = "materia")
    private String materia;

    public Docentes() {
    }

    public Docentes(Integer id) {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
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
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Docentes[ id=" + id + " ]";
    }
    
}
