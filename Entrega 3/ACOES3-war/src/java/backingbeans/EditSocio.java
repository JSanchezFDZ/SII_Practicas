/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import modelos.SociosFacade;


@Named(value = "EditSocio")
@SessionScoped
public class EditSocio implements Serializable {
    @EJB
    private SociosFacade sociosFacade;
    private Socios s = new Socios();

    
    /*Constructor vacio*/
    public EditSocio(){
       
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
    
    
    public Long getId(){
        return s.getId();
    }
    
    public String edit(Socios s){
        this.s = s;
        return "modificarSocio.xhtml";
    }
    
    public String editSocio(){
        this.sociosFacade.edit(this.s);
        return "verSocio.xhtml";
    }
    
}