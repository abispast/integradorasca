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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abisai
 */
@Entity
@Table(name = "ubicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u")
    , @NamedQuery(name = "Ubicaciones.findByIdUbicacion", query = "SELECT u FROM Ubicaciones u WHERE u.idUbicacion = :idUbicacion")
    , @NamedQuery(name = "Ubicaciones.findByIdUsuario", query = "SELECT u FROM Ubicaciones u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Ubicaciones.findByLatitud", query = "SELECT u FROM Ubicaciones u WHERE u.latitud = :latitud")
    , @NamedQuery(name = "Ubicaciones.findByLongitud", query = "SELECT u FROM Ubicaciones u WHERE u.longitud = :longitud")
    , @NamedQuery(name = "Ubicaciones.findByFecha", query = "SELECT u FROM Ubicaciones u WHERE u.fecha = :fecha")})
public class Ubicaciones implements Serializable {

    @Column(name = "horaRegistro")
    @Temporal(TemporalType.TIME)
    private Date horaRegistro;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUbicacion")
    private Integer idUbicacion;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 255)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 255)
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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
        hash += (idUbicacion != null ? idUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.idUbicacion == null && other.idUbicacion != null) || (this.idUbicacion != null && !this.idUbicacion.equals(other.idUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Ubicaciones[ idUbicacion=" + idUbicacion + " ]";
    }

    public Date getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Date horaRegistro) {
        this.horaRegistro = horaRegistro;
    }
    
}
