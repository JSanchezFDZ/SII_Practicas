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
    private Long codigoApadrinamiento;
    private Ninos codigoNino;
 //   private Socios numSocio;
    private String fechaApadrinamiento;
    private String observaciones;

    public Long getId() {
        return codigoApadrinamiento;
    }

    public void setId(Long id) {
        this.codigoApadrinamiento = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoApadrinamiento != null ? codigoApadrinamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apadrinamiento)) {
            return false;
        }
        Apadrinamiento other = (Apadrinamiento) object;
        if ((this.codigoApadrinamiento == null && other.codigoApadrinamiento != null) || (this.codigoApadrinamiento != null && !this.codigoApadrinamiento.equals(other.codigoApadrinamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.Apadrinamiento[ id=" + codigoApadrinamiento + " ]";
    }
    
}
