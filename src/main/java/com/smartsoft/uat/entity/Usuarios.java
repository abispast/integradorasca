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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodzk
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findAllActivos", query = "SELECT u FROM Usuarios u WHERE u.activo = true")
    , @NamedQuery(name = "Usuarios.existe", query = "SELECT u FROM Usuarios u WHERE u.activo = true and u.correo = :correo") 
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellidoPaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Usuarios.findByApellidoMaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad")
    , @NamedQuery(name = "Usuarios.findByFechaRegistro", query = "SELECT u FROM Usuarios u WHERE u.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Usuarios.findByFechaElimino", query = "SELECT u FROM Usuarios u WHERE u.fechaElimino = :fechaElimino")
    , @NamedQuery(name = "Usuarios.findByIdRegistro", query = "SELECT u FROM Usuarios u WHERE u.idRegistro = :idRegistro")
    , @NamedQuery(name = "Usuarios.findByIdElimino", query = "SELECT u FROM Usuarios u WHERE u.idElimino = :idElimino")
    , @NamedQuery(name = "Usuarios.findByRol", query = "SELECT u FROM Usuarios u WHERE u.rol = :rol")
    , @NamedQuery(name = "Usuarios.findByUser", query = "SELECT u FROM Usuarios u WHERE u.user = :user")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Size(max = 255)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Size(max = 255)
    @Column(name = "correo")
    private String correo;
    @Size(max = 255)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_elimino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElimino;
    @Column(name = "id_registro")
    private Integer idRegistro;
    @Column(name = "id_elimino")
    private Integer idElimino;
    @Column(name = "rol")
    private Integer rol;
    @Column(name = "user")
    private Integer user;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaElimino() {
        return fechaElimino;
    }

    public void setFechaElimino(Date fechaElimino) {
        this.fechaElimino = fechaElimino;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdElimino() {
        return idElimino;
    }

    public void setIdElimino(Integer idElimino) {
        this.idElimino = idElimino;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Usuarios[ id=" + id + " ]";
    }
    
}
