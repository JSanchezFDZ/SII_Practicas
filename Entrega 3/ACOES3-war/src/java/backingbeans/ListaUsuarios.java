/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import entidades.Usuario.Rol;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import modelos.UsuarioFacade;

/**
 *
 * @author Jesús Correa Conejero
 */
@Named(value = "ListaUsuarios")
@RequestScoped
public class ListaUsuarios implements Serializable {
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario u = new Usuario();

    
    /*Constructor vacio*/
    public ListaUsuarios(){
        
    }
    
    public List<Usuario> findAll(){
        return this.usuarioFacade.findAll();
    }
    
    
    // Chapuzilla by JSanchezFDZ
    public List<Usuario> findAllLibres(){
        List<Usuario> libres = new ArrayList<>();
        for (Usuario usu : this.usuarioFacade.findAll()) {
            if(usu.getSocio() == null){
                libres.add(usu);
            }
        } 
        return libres;
    }
    
    public Rol[] getRoles(){
        return Rol.values();
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    
    
    public String crearUsuario(){
        return "insertarUsuario.xhtml";
    }
    
    public String add(){
        this.usuarioFacade.create(this.u);
        this.u = new Usuario();
        return "listausuarios.xhtml";
    }
    
    public void delete(Usuario u){
        this.usuarioFacade.remove(u);
    }
    
    public String edit(Usuario u){
        this.u = u;
        return "modificarUsuario.xhtml";
    }
    
    public String edit(){
        this.usuarioFacade.edit(this.u);
        return "listausuarios.xhtml";
    }
    
}