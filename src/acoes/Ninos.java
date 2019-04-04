/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edu Ruiz
 */

@Entity
public class Ninos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellidos;
    private String estado;
    private String beca;
    private String sexo;
    private String agente;
    private String foto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    private String proyecto;
    private String gradoCurso;
    private String comunidadProcedencia;
    private String coloniaActual;
    private String observaciones;
    //private Apadrinamiento codApadrinamiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public String getBeca() {
        return beca;
    }

    public String getSexo() {
        return sexo;
    }

    public String getAgente() {
        return agente;
    }

    public String getFoto() {
        return foto;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public String getProyecto() {
        return proyecto;
    }

    public String getGradoCurso() {
        return gradoCurso;
    }

    public String getComunidadProcedencia() {
        return comunidadProcedencia;
    }

    public String getColoniaActual() {
        return coloniaActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public void setGradoCurso(String gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    public void setComunidadProcedencia(String comunidadProcedencia) {
        this.comunidadProcedencia = comunidadProcedencia;
    }

    public void setColoniaActual(String coloniaActual) {
        this.coloniaActual = coloniaActual;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /*public Apadrinamiento getCodApadrinamiento() {
        return codApadrinamiento;
    }

    public void setCodApadrinamiento(Apadrinamiento codApadrinamiento) {
        this.codApadrinamiento = codApadrinamiento;
    }*/
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ninos)) {
            return false;
        }
        Ninos other = (Ninos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.Ninos[ id=" + id + " ]";
    }
    
}
