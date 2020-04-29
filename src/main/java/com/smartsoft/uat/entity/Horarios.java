/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
 * @author Abisai
 */
@Entity
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findById", query = "SELECT h FROM Horarios h WHERE h.id = :id")
    , @NamedQuery(name = "Horarios.findByActivo", query = "SELECT h FROM Horarios h WHERE h.activo = :activo")
    , @NamedQuery(name = "Horarios.findByActivos", query = "SELECT h FROM Horarios h WHERE h.activo = true")    
    , @NamedQuery(name = "Horarios.findByPeriodo", query = "SELECT h FROM Horarios h WHERE h.periodo = :periodo")
    , @NamedQuery(name = "Horarios.findByFoliomateria", query = "SELECT h FROM Horarios h WHERE h.foliomateria = :foliomateria")
    , @NamedQuery(name = "Horarios.findByNombre", query = "SELECT h FROM Horarios h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Horarios.findByGrado", query = "SELECT h FROM Horarios h WHERE h.grado = :grado")
    , @NamedQuery(name = "Horarios.findByGrupo", query = "SELECT h FROM Horarios h WHERE h.grupo = :grupo")
    , @NamedQuery(name = "Horarios.findByNombreDo", query = "SELECT h FROM Horarios h WHERE h.nombreDo = :nombreDo")
    , @NamedQuery(name = "Horarios.findByApellidoma", query = "SELECT h FROM Horarios h WHERE h.apellidoma = :apellidoma")
    , @NamedQuery(name = "Horarios.findByApellidopa", query = "SELECT h FROM Horarios h WHERE h.apellidopa = :apellidopa")
    , @NamedQuery(name = "Horarios.findBySalon", query = "SELECT h FROM Horarios h WHERE h.salon = :salon")
    , @NamedQuery(name = "Horarios.findByLunesInicio", query = "SELECT h FROM Horarios h WHERE h.lunesInicio = :lunesInicio")
    , @NamedQuery(name = "Horarios.findByLunesFin", query = "SELECT h FROM Horarios h WHERE h.lunesFin = :lunesFin")
    , @NamedQuery(name = "Horarios.findByMartesInicio", query = "SELECT h FROM Horarios h WHERE h.martesInicio = :martesInicio")
    , @NamedQuery(name = "Horarios.findByMartesFin", query = "SELECT h FROM Horarios h WHERE h.martesFin = :martesFin")
    , @NamedQuery(name = "Horarios.findByMiercolesInicio", query = "SELECT h FROM Horarios h WHERE h.miercolesInicio = :miercolesInicio")
    , @NamedQuery(name = "Horarios.findByMiercolesFin", query = "SELECT h FROM Horarios h WHERE h.miercolesFin = :miercolesFin")
    , @NamedQuery(name = "Horarios.findByJuevesInicio", query = "SELECT h FROM Horarios h WHERE h.juevesInicio = :juevesInicio")
    , @NamedQuery(name = "Horarios.findByJuevesFin", query = "SELECT h FROM Horarios h WHERE h.juevesFin = :juevesFin")
    , @NamedQuery(name = "Horarios.findByViernesInicio", query = "SELECT h FROM Horarios h WHERE h.viernesInicio = :viernesInicio")
    , @NamedQuery(name = "Horarios.findByViernesFin", query = "SELECT h FROM Horarios h WHERE h.viernesFin = :viernesFin")
    , @NamedQuery(name = "Horarios.findByFechaRegistro", query = "SELECT h FROM Horarios h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Horarios.findByFechaElimino", query = "SELECT h FROM Horarios h WHERE h.fechaElimino = :fechaElimino")
    , @NamedQuery(name = "Horarios.findByIdRegistro", query = "SELECT h FROM Horarios h WHERE h.idRegistro = :idRegistro")
    , @NamedQuery(name = "Horarios.findByIdElimino", query = "SELECT h FROM Horarios h WHERE h.idElimino = :idElimino")})
public class Horarios implements Serializable {

    @Column(name = "activo")
    private Boolean activo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "periodo")
    private String periodo;
    @Size(max = 255)
    @Column(name = "foliomateria")
    private String foliomateria;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "grado")
    private Integer grado;
    @Size(max = 255)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 255)
    @Column(name = "nombreDo")
    private String nombreDo;
    @Size(max = 255)
    @Column(name = "apellidoma")
    private String apellidoma;
    @Size(max = 255)
    @Column(name = "apellidopa")
    private String apellidopa;
    @Size(max = 255)
    @Column(name = "salon")
    private String salon;
    @Column(name = "lunes_inicio")
    @Temporal(TemporalType.TIME)
    private Date lunesInicio;
    @Column(name = "lunes_fin")
    @Temporal(TemporalType.TIME)
    private Date lunesFin;
    @Column(name = "martes_inicio")
    @Temporal(TemporalType.TIME)
    private Date martesInicio;
    @Column(name = "martes_fin")
    @Temporal(TemporalType.TIME)
    private Date martesFin;
    @Column(name = "miercoles_inicio")
    @Temporal(TemporalType.TIME)
    private Date miercolesInicio;
    @Column(name = "miercoles_fin")
    @Temporal(TemporalType.TIME)
    private Date miercolesFin;
    @Column(name = "jueves_inicio")
    @Temporal(TemporalType.TIME)
    private Date juevesInicio;
    @Column(name = "jueves_fin")
    @Temporal(TemporalType.TIME)
    private Date juevesFin;
    @Column(name = "viernes_inicio")
    @Temporal(TemporalType.TIME)
    private Date viernesInicio;
    @Column(name = "viernes_fin")
    @Temporal(TemporalType.TIME)
    private Date viernesFin;
    @Column(name = "fecha_Registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_Elimino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElimino;
    @Column(name = "id_Registro")
    private Integer idRegistro;
    @Column(name = "id_Elimino")
    private Integer idElimino;

    public Horarios() {
    }

    public Horarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFoliomateria() {
        return foliomateria;
    }

    public void setFoliomateria(String foliomateria) {
        this.foliomateria = foliomateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombreDo() {
        return nombreDo;
    }

    public void setNombreDo(String nombreDo) {
        this.nombreDo = nombreDo;
    }

    public String getApellidoma() {
        return apellidoma;
    }

    public void setApellidoma(String apellidoma) {
        this.apellidoma = apellidoma;
    }

    public String getApellidopa() {
        return apellidopa;
    }

    public void setApellidopa(String apellidopa) {
        this.apellidopa = apellidopa;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Date getLunesInicio() {
        return lunesInicio;
    }

    public void setLunesInicio(Date lunesInicio) {
        this.lunesInicio = lunesInicio;
    }

    public Date getLunesFin() {
        return lunesFin;
    }

    public void setLunesFin(Date lunesFin) {
        this.lunesFin = lunesFin;
    }

    public Date getMartesInicio() {
        return martesInicio;
    }

    public void setMartesInicio(Date martesInicio) {
        this.martesInicio = martesInicio;
    }

    public Date getMartesFin() {
        return martesFin;
    }

    public void setMartesFin(Date martesFin) {
        this.martesFin = martesFin;
    }

    public Date getMiercolesInicio() {
        return miercolesInicio;
    }

    public void setMiercolesInicio(Date miercolesInicio) {
        this.miercolesInicio = miercolesInicio;
    }

    public Date getMiercolesFin() {
        return miercolesFin;
    }

    public void setMiercolesFin(Date miercolesFin) {
        this.miercolesFin = miercolesFin;
    }

    public Date getJuevesInicio() {
        return juevesInicio;
    }

    public void setJuevesInicio(Date juevesInicio) {
        this.juevesInicio = juevesInicio;
    }

    public Date getJuevesFin() {
        return juevesFin;
    }

    public void setJuevesFin(Date juevesFin) {
        this.juevesFin = juevesFin;
    }

    public Date getViernesInicio() {
        return viernesInicio;
    }

    public void setViernesInicio(Date viernesInicio) {
        this.viernesInicio = viernesInicio;
    }

    public Date getViernesFin() {
        return viernesFin;
    }

    public void setViernesFin(Date viernesFin) {
        this.viernesFin = viernesFin;
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

    public String getLunesInicioString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (lunesInicio != null) ? format.format(lunesInicio) : "";
    }

    public String getLunesFinString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (lunesFin != null) ? format.format(lunesFin) : "";
    }

    public String getMartesInicioString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (martesInicio != null) ? format.format(martesInicio) : "";
    }

    public String getMartesFinString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (martesFin != null)? format.format(martesFin):"";
    }

    public String getMiercolesInicioString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (miercolesInicio!=null)?format.format(miercolesInicio):"";
    }

    public String getMiercolesFinString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (miercolesFin!=null)?format.format(miercolesFin):"";
    }

    public String getJuevesInicioString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (juevesInicio!=null)?format.format(juevesInicio):"";
    }

    public String getJuevesFinString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (juevesFin!=null)?format.format(juevesFin):"";
    }

    public String getViernesInicioString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (viernesInicio!=null)?format.format(viernesInicio):"";
    }

    public String getViernesFinString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return (viernesFin!=null)?format.format(viernesFin):"";
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
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Horarios[ id=" + id + " ]";
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
