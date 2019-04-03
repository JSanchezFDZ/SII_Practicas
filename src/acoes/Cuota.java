/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sergio
 */
public class Cuota implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoCuota;
    private String nombreCuota;
    private String tipo;    //puntual, mensual, anual...
    private float cantidad;

    public String getCodigoCuota() {
        return codigoCuota;
    }

    public String getNombreCuota() {
        return nombreCuota;
    }

    public String getTipo() {
        return tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCodigoCuota(String codigoCuota) {
        this.codigoCuota = codigoCuota;
    }

    public void setNombreCuota(String nombreCuota) {
        this.nombreCuota = nombreCuota;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigoCuota);
        hash = 67 * hash + Objects.hashCode(this.nombreCuota);
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Float.floatToIntBits(this.cantidad);
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
        if (Float.floatToIntBits(this.cantidad) != Float.floatToIntBits(other.cantidad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuota{" + "codigoCuota=" + codigoCuota + ", nombreCuota=" + nombreCuota + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }
    
    
    
}
