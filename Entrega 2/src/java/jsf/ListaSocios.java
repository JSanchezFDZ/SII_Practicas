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
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jaime Moreno Sánchez
 */
@Named(value = "ListaSocios")
@SessionScoped
public class ListaSocios implements Serializable {
    private List<Socios> socios;
    private Usuario usuario;
    private Login user;
    private List<Usuario> usuarios = user.getUsuarios();
    
    public ListaSocios(){
        socios = new ArrayList<>();
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }  
    
    public List<Socios> getSocios(){
        return socios;
    }
    
    
    public List<Socios> añadirSocio (List<Usuario> usuarios){
        
        for(int i = 0; i < usuarios.size(); i++){
            Socios aux = null;
           if(usuarios.get(i).getRol() == SOCIO){
                 aux.setNombre(usuarios.get(i).getUser());
                 aux.setApellido(usuarios.get(i).getApellidos());
                 aux.setId(usuarios.get(i).getUserID());
           }
            if(aux != null){
                socios.add(aux);
            }
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