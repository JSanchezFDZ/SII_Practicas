/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    private Socios[] socios;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }
    
    public Socios[] getSocios() {
        return socios;
    }
    
    public String ListaUsuarios(){
        return "listausuarios.xhtml";
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
        return "verSocio.xhtml";
    }
    
    public String MisCuotas(){
        return "verCuotas.xhtml";
    }
    
    public String ListaEnvios(){
        return "listaenvios.xhtml";
    }

    public String home() {
        // Devuelve la página Home dependiendo del rol del usuario
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().SOCIO)){
            return "inicio.xhtml";
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

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
