/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Salva
 */
@Entity
public class Apadrinamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codApadrinamiento;
    private Ninos codNino;
 //   private Socios numSocio;
    private String fechaApadrinamiento;
    private String observaciones;

    public Long getCodApadrinamiento() {
        return codApadrinamiento;
    }

    public void setCodApadrinamiento(Long id) {
        this.codApadrinamiento = id;
    }

    public Ninos getCodNino() {
        return codNino;
    }

    public void setCodNino(Ninos codNino) {
        this.codNino = codNino;
    }

    public String getFechaApadrinamiento() {
        return fechaApadrinamiento;
    }

    public void setFechaApadrinamiento(String fechaApadrinamiento) {
        this.fechaApadrinamiento = fechaApadrinamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codApadrinamiento != null ? codApadrinamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apadrinamiento)) {
            return false;
        }
        Apadrinamiento other = (Apadrinamiento) object;
        if ((this.codApadrinamiento == null && other.codApadrinamiento != null) || (this.codApadrinamiento != null && !this.codApadrinamiento.equals(other.codApadrinamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.Apadrinamiento[ id=" + codApadrinamiento + " ]";
    }
    
}
