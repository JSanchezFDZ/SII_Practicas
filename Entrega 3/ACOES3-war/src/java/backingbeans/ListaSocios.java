/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import excepciones.AcoesException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import modelos.SociosFacade;
import modelos.UsuarioFacade;

/**
 *
 * @author Jaime Moreno Sánchez
 */
@Named(value = "ListaSocios")
@SessionScoped
public class ListaSocios implements Serializable {
    @EJB
    private SociosFacade sociosFacade;
    @EJB
    private UsuarioFacade usuariosFacade;  
    private Usuario usuario;
    private Socios s = new Socios();

    
    /*Constructor vacio*/
    public ListaSocios(){
       
    }
    

    
    public List<Socios> findAll(){
        return this.sociosFacade.findAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Socios getS() {
        return s;
    }
    
    

    public void setS(Socios s) {
        this.s = s;
    }
    
    public String crearSocio(){
        return "insertarSocio.xhtml";
    }
    
    
    public Long getId(){
        return s.getId();
    }
    
    public String add(String cuenta) {
            usuario = usuariosFacade.find(cuenta);
            usuario.setSocio(s);
            usuariosFacade.edit(usuario);
            //sociosFacade.create(s);
            //this.s=new Socios();
            return "listasocios.xhtml";
    }
    
    public void delete(Socios s){
        this.sociosFacade.remove(s);
    }
    
    public String edit(Socios s){
        this.s = s;
        return "modificarSocio.xhtml";
    }
    
    public String edit(){
        this.sociosFacade.edit(this.s);
        return "listasocios.xhtml";
    }
    
     public String editSocio(){
        this.sociosFacade.edit(this.s);
        return "verSocio.xhtml";
    }
    
}