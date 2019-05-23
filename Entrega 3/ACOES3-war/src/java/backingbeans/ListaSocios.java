/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelos.SociosFacade;

/**
 *
 * @author Jaime Moreno Sánchez
 */
@Named(value = "ListaSocios")
@SessionScoped
public class ListaSocios implements Serializable {
    @EJB
    private SociosFacade sociosFacade;
    private Socios s = new Socios();

    
    /*Constructor vacio*/
    public ListaSocios(){

    }
    
    public List<Socios> findAll(){
        return this.sociosFacade.findAll();
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
    
    public String add(){
        this.sociosFacade.create(this.s);
        this.s=new Socios();
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
    
}