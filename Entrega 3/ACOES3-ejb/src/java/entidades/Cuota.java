/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jesús Correa Conejero
 */
@Entity
public class Cuota implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoCuota;
    private String nombreCuota;
    private String tipo;    //puntual, mensual, anual...
    private float aportación;
    @ManyToMany
    @JoinTable(name="CUOTA_SOCIOS", joinColumns = @JoinColumn(name = "Cuota_FK"), inverseJoinColumns = 
            @JoinColumn(name = "Socio_FK"))
    private List<Socios> codigoSocios;

    public Cuota(Long codigoCuota, String nombreCuota, String tipo, float aportación, List<Socios> codigoSocios) {
        this.codigoCuota = codigoCuota;
        this.nombreCuota = nombreCuota;
        this.tipo = tipo;
        this.aportación = aportación;
        this.codigoSocios = codigoSocios;
    }

    public Cuota() {
    }
    
    public Cuota(Long codigoCuota, String nombreCuota, String tipo, float aportación) {
        this.codigoCuota = codigoCuota;
        this.nombreCuota = nombreCuota;
        this.tipo = tipo;
        this.aportación = aportación;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCodigoCuota() {
        return codigoCuota;
    }

    public String getNombreCuota() {
        return nombreCuota;
    }

    public String getTipo() {
        return tipo;
    }

    public float getAportación() {
        return aportación;
    }
   

    public List<Socios> getCodigoSocios() {
        return codigoSocios;
    }

    public void setCodigoCuota(Long codigoCuota) {
        this.codigoCuota = codigoCuota;
    }

    public void setNombreCuota(String nombreCuota) {
        this.nombreCuota = nombreCuota;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAportación(float aportación) {
        this.aportación = aportación;
    }

    public void setCodigoSocios(List<Socios> codigoSocios) {
        this.codigoSocios = codigoSocios;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigoCuota);
        hash = 79 * hash + Objects.hashCode(this.nombreCuota);
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + Float.floatToIntBits(this.aportación);
        hash = 79 * hash + Objects.hashCode(this.codigoSocios);
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
        final Cuota other = (Cuota) obj;
        if (!Objects.equals(this.codigoCuota, other.codigoCuota)) {
            return false;
        }
        if (!Objects.equals(this.nombreCuota, other.nombreCuota)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (Float.floatToIntBits(this.aportación) != Float.floatToIntBits(other.aportación)) {
            return false;
        }
        if (!Objects.equals(this.codigoSocios, other.codigoSocios)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCuota;
    }

  
    
    
}
