/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Apadrinamiento;
import acoes.Cuota;
import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import static acoes.Usuario.Rol.SOCIO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Edu Ruiz
 */

@Named(value = "ListaNinos")
@SessionScoped
public class ListaNinos implements Serializable{
    private ArrayList<Ninos> ninos;
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }  
    
    public ListaNinos(){
        ninos = new ArrayList<>();
        ninos.add(new Ninos(new Long(1), "Bruce", "Wayne", new Date(2000, 11, 21)));
        ninos.add(new Ninos(new Long(2), "Tony", "Stark", new Date(1999, 11, 21)));
    }
    
    public ArrayList<Ninos> getNinos(){
        return ninos;
    }
    
    public String registrarNino(){
        return "registrarnino.xhtml";
    }
    
    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        // Si el usuario es un administrador, le lleva a la pagina de niños solicitada
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "ListaNinos.xhtml";
        }
        
        // Si el usuario es socio, le lleva a la pagina de socios
        if(getUsuario().getRol().equals(getUsuario().getRol().SOCIO)){
            return "login.xhtml";
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
