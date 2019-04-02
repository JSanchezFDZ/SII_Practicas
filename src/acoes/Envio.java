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

/**
 *
 * @author SalvaP
 */
@Entity
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codEnvio;
    private String codApadrinamiento;
    private Date fechaEnvio;
    private Date fechaLlegada;
    private String observaciones;
            
            
    public Long getCodEnvio() {
        return codEnvio;
    }

    public void setCodEnvio(Long id) {
        this.codEnvio = id;
    }
    
    public String getCodApadrinamiento() {
        return codApadrinamiento;
    }

    public void setCodApadrinamiento(String codApadrinamiento) {
        this.codApadrinamiento = codApadrinamiento;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
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
        hash += (codEnvio != null ? codEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.codEnvio == null && other.codEnvio != null) || (this.codEnvio != null && !this.codEnvio.equals(other.codEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.Envio[ id=" + codEnvio + " ]";
    }
    
}
