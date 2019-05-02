/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import static acoes.Usuario.Rol.SOCIO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jaime Moreno Sánchez
 */
@Named(value = "ListaSocios")
@SessionScoped
public class ListaSocios implements Serializable {
    private ArrayList<Socios> socios;
    private Usuario usuario;
    
    public ListaSocios(){
        socios = new ArrayList<>();
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }  
    
    public ArrayList<Socios> getSocios(){
        return socios;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Socios> añadirSocio(){
        if(this.usuario.getRol() == SOCIO){
            
            socios.add(new Socios(this.usuario.getUser(), this.usuario.getUserID(), this.usuario.getRol()));
        }
        return socios;
    }
    
    public String home() {
        
        // Si no ha iniciado sesion, le lleva al login
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Socios
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "ListaSocios.xhtml";
        }
        
        // Si el usuario es SOCIO, le llevará a la página web de INDEX
        // REVISAR
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
//Mostrar todos los socios. Solo para administrador.