/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApadrinamiento;
    private String observaciones;
    @OneToOne
    private Ninos codNino;
    @ManyToOne
    private Socios numSocio;
    @OneToMany
    private List<Envio> codEnvio;

    public Apadrinamiento() {
    }

    public Apadrinamiento(Long codApadrinamiento, Ninos codNino, Socios numSocio, List<Envio> codEnvio, Date fechaApadrinamiento, String observaciones) {
        this.codApadrinamiento = codApadrinamiento;
        this.codNino = codNino;
        this.numSocio = numSocio;
        this.codEnvio = codEnvio;
        this.fechaApadrinamiento = fechaApadrinamiento;
        this.observaciones = observaciones;
    }
    
    public Apadrinamiento(Long codA, Ninos codNin, Socios numSoc, List<Envio> codEnv){
        codApadrinamiento = codA;
        codNino = codNin;
        numSocio = numSoc;
        codEnvio = codEnv;
    }

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

    public Date getFechaApadrinamiento() {
        return fechaApadrinamiento;
    }

    public void setFechaApadrinamiento(Date fechaApadrinamiento) {
        this.fechaApadrinamiento = fechaApadrinamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Socios getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(Socios numSocio) {
        this.numSocio = numSocio;
    }

    public List<Envio> getCodEnvio() {
        return codEnvio;
    }

    public void setCodEnvio(List<Envio> codEnvio) {
        this.codEnvio = codEnvio;
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
        return codNino.getNombre() + " " + codNino.getApellidos();
    }
    
}
