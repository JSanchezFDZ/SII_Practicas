/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Long getID(){
        return usuario.getUserID();
    }

    public Usuario getUsuario() {
        return usuario;
    }
<<<<<<< HEAD
    
    public Socios[] getSocios() {
        return socios;
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
=======
>>>>>>> master

    public String home() {
        // Devuelve la página Home dependiendo del rol del usuario
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "admin.xhtml";
        }
        
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

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
