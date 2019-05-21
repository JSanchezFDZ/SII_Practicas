/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Salva
 */
    @Named(value = "ListaApadrinamientos")
    @SessionScoped
    
public class ListaApadrinamientos implements Serializable {
    private List<Apadrinamiento> lApadrinamiento;
    private Ninos ninio;
    private Socios socio;
    private List<Envio> envio;
    
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
     public ListaApadrinamientos(){
        lApadrinamiento = new ArrayList<>();
        
        ninio = (new Ninos(new Long(1), "Bruce", "Wayne", new Date(2000, 11, 21)));
        socio = (new Socios(" Pepe "," Gutierrez ", new Long(70001)," Soltero ", " C/SinNombre nº 5","Narnia ",00000,"El baticano",
        "111 222 333", "pepeG@gmail.com", "", "Activo", null, null, "", usuario));
                
        lApadrinamiento.add(new Apadrinamiento((long) 0001, ninio, socio, envio));
        lApadrinamiento.add(new Apadrinamiento((long) 0002, ninio, socio, envio));
    }


    public Ninos getNinio() {
        return ninio;
    }

    public void setNinio(Ninos ninio) {
        this.ninio = ninio;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public List<Envio> getEnvio() {
        return envio;
    }

    public void setEnvio(List<Envio> envio) {
        this.envio = envio;
    }


    public List<Apadrinamiento> getlApadrinamiento() {
        return lApadrinamiento;
    }

    public void setlApadrinamiento(List<Apadrinamiento> lApadrinamiento) {
        this.lApadrinamiento = lApadrinamiento;
    }
    

    
     public String home() {
        
        // Si no ha iniciado sesion, le lleva al login
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        // Si el usuario es un administrador, le lleva a la pagina del listado de apadrinados
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "listaninosapadrinados.xhtml";
        }
        
        // Si el usuario es socio, le lleva a la pagina de apadrinar
        if(getUsuario().getRol().equals(getUsuario().getRol().SOCIO)){
            return "apadrinar.xhtml";
        }
        return null;
    }
         
     public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
}
