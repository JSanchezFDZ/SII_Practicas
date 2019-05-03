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
 * @author Jaime Moreno Sánchez
 */
@Named(value = "ListaSocios")
@SessionScoped
public class ListaSocios implements Serializable {
    private final ArrayList<Socios> socios;
    private Usuario usuario;
    private ArrayList<Apadrinamiento>apadrinamientos;
    private List<Cuota> cuotas;
    
    public ListaSocios(){
        socios = new ArrayList<>();
        socios.add(new Socios("Pepe","Gutierrez", new Long(70001),"Soltero","C/Sin nombre nº -5","Narnia",00000,"El baticano",
        "111 222 333", "pepeG@gmail.com", "    ", "Activo", new Date(118, 5, 3), new Date(000, 0, 0), "  ", usuario, apadrinamientos, cuotas));
    }
    
    public ArrayList<Socios> getSocios(){
        return socios;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }  
    /**
     *
     * @return
     */
    /*
      public ArrayList<Socios> añadirSocio(){
       
        if(usuario.getRol() == SOCIO){
            
            socios.add(new Socios("pepe", new Long(7001)));
        }
        return socios;
    }
    */
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