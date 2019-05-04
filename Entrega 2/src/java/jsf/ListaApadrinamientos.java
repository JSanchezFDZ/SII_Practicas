/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Apadrinamiento;
import acoes.Envio;
import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import java.util.ArrayList;
import javax.faces.context.FacesContext;

/**
 *
 * @author Salva
 */
public class ListaApadrinamientos {
    private ArrayList<Apadrinamiento> lApadrinamiento;
    private Ninos ninio;
    private Socios socio;
    private Envio envio;
    
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
     public void ListaApadrinamiento(){
        lApadrinamiento = new ArrayList<>();
        lApadrinamiento.add(new Apadrinamiento((long) 0001, ninio, socio, envio));
        lApadrinamiento.add(new Apadrinamiento((long) 0002, ninio, socio, envio));
    }

    public ArrayList<Apadrinamiento> getlApadrinamiento() {
        return lApadrinamiento;
    }

    public void setlApadrinamiento(ArrayList<Apadrinamiento> lApadrinamiento) {
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
