/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @ManyToOne
    private Apadrinamiento codApadrinamiento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    private String observaciones;

    public Envio(Long codEnvio, Apadrinamiento codApadrinamiento, Date fechaEnvio, Date fechaLlegada, String observaciones) {
        this.codEnvio = codEnvio;
        this.codApadrinamiento = codApadrinamiento;
        this.fechaEnvio = fechaEnvio;
        this.fechaLlegada = fechaLlegada;
        this.observaciones = observaciones;
    }

    public Envio() {
    }

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
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codEnvio);
        hash = 79 * hash + Objects.hashCode(this.codApadrinamiento);
        hash = 79 * hash + Objects.hashCode(this.fechaEnvio);
        hash = 79 * hash + Objects.hashCode(this.fechaLlegada);
        hash = 79 * hash + Objects.hashCode(this.observaciones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Envio other = (Envio) obj;
        if (!Objects.equals(this.codEnvio, other.codEnvio)) {
            return false;
        }
        if (!Objects.equals(this.codApadrinamiento, other.codApadrinamiento)) {
            return false;
        }
        if (!Objects.equals(this.fechaEnvio, other.fechaEnvio)) {
            return false;
        }
        if (!Objects.equals(this.fechaLlegada, other.fechaLlegada)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        return true;
    }

   



    @Override
    public String toString() {
        return "Envio{" + "codEnvio=" + codEnvio + ", codApadrinamiento=" + codApadrinamiento + ", fechaEnvio=" + fechaEnvio + ", fechaLlegada=" + fechaLlegada + ", observaciones=" + observaciones + '}';
    }
  
    
}
