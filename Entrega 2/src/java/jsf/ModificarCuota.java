/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Cuota;
import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jesús Correa Conejero
 */

@Named(value = "ModificarCuota")
@SessionScoped
public class ModificarCuota implements Serializable {
    private Cuota cuota;
    private Socios socio;

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }
    
    public Long getCodigoCuota(){
        return this.cuota.getCodigoCuota();
    }
    
     public String getNombreCuota() {
        return this.cuota.getNombreCuota();
    }

    public String getTipoCuota() {
        return this.cuota.getTipo();
    }

    public float getAportaciónCuota() {
        return this.cuota.getAportación();
    }
   

    public List<Socios> getCodigoSocios() {
        return this.cuota.getCodigoSocios();
    }

    
    public String ListaSocios(){
        return "listasocios.xhtml";
    }
    
    public String ListaNinos(){
        return "listaninos.xhtml";
    }
    
    public String NinosApadrinados(){
        return "listaninosapadrinados.xhtml";
    }
    
    public String Cuotas(){
        return "listacuotas.xhtml";
    }
    
    public String MisDatos(){
        return "socio.xhtml";
    }
    
    public String ListaEnvios(){
        return "envio.xhtml";
    }
    
 
    public String verCuota(Long cod){
        this.cuota = new Cuota((long) 1, "Estándar", "Mensual", 20);
        
        return "modificarCuota.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ModificarCuota() {
    }
}

