/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Ninos;
import acoes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Edu
 */

@Named(value = "ListaNinos")
@SessionScoped
public class ListaNinos implements Serializable{
    private Ninos[] nino;
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }  
    
    public Ninos[] getNinos(){
        return nino;
    }
    
    public String home() {
        
        // Si no ha iniciado sesion, le lleva al login
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        // Si el usuario es un administrador, le lleva a la pagina de niños solicitada
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "ninos.xhtml";
        }
        
        // Si el usuario es socio, le lleva a la pagina de socios
        if(getUsuario().getRol().equals(getUsuario().getRol().SOCIO)){
            return "socio.xhtml";
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
