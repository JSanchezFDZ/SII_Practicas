/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Salva
 */
@Named(value = "ModificarApadrinamientos")
@SessionScoped
public class modificarApadrinamientos implements Serializable{
    private Ninos ninio;
    private Apadrinamiento apadrinamiento;
    private Socios socio;
    private List<Envio> envio;

    public Ninos getNinio() {
        return ninio;
    }

    public void setNinio(Ninos ninio) {
        this.ninio = ninio;
    }

    public Apadrinamiento getApadrinamiento() {
        return apadrinamiento;
    }

    public void setApadrinamiento(Apadrinamiento apadrinamiento) {
        this.apadrinamiento = apadrinamiento;
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
        this.apadrinamiento = new Apadrinamiento((long) 00000, ninio, socio, envio);
        
        return "modificarApadrinamientos.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public modificarApadrinamientos() {
    }
}
