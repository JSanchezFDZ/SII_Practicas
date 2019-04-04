/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
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
 * @author SalvaP
 */
@Entity
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codEnvio;
    private Apadrinamiento codApadrinamiento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    private String observaciones;
            
            
    public Long getCodEnvio() {
        return codEnvio;
    }

    public void setCodEnvio(Long id) {
        this.codEnvio = id;
    }
    
    public Apadrinamiento getCodApadrinamiento() {
        return codApadrinamiento;
    }

    public void setCodApadrinamiento(Apadrinamiento codApadrinamiento) {
        this.codApadrinamiento = codApadrinamiento;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
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
