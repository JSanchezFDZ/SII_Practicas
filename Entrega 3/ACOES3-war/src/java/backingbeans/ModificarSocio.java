/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jesús Correa Conejero
 */

@Named(value = "ModificarSocio")
@SessionScoped
public class ModificarSocio implements Serializable {
    private Socios socio;


    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }
    
     public Long getId() {
        return this.socio.getId();
    }


    public String getNombre() {
        return this.socio.getNombre();
    }

    public String getApellido() {
        return this.socio.getApellido();
    }

    public String getEstado() {
        return this.socio.getEstado();
    }

    public String getDireccion() {
        return this.socio.getDireccion();
    }

    public String getPoblacion() {
        return this.socio.getPoblacion();
    }

    public int getCodPostal() {
        return this.socio.getCodPostal();
    }

    public String getProvincia() {
        return this.socio.getProvincia();
    }

    public String getTelefono() {
        return this.socio.getTelefono();
    }

    public String getCorreo() {
        return this.socio.getCorreo();
    }


    public String getSector() {
        return this.socio.getSector();
    }


    public String getFechaAlta() {
        return this.socio.getFechaAlta();
    }

    public String getFechaBaja() {
        return this.socio.getFechaBaja();
    }


    public String getObservaciones() {
        return this.socio.getObservaciones();
    }

    public Usuario getUser() {
        return this.socio.getUsuario();
    }     
            
    public String getCertificado() {
        return this.socio.getCertificado();
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
    
 
    public String verSocio(Long cod){
        return "modificarSocio.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ModificarSocio() {
    }
}

