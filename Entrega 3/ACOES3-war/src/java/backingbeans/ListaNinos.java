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
import modelos.NinosFacade;

/**
 *
 * @author Edu Ruiz
 */

@Named(value = "ListaNinos")
@SessionScoped
public class ListaNinos implements Serializable{
    @EJB
    private NinosFacade ninosFacade;
    private Ninos s = new Ninos();

    
    /*Constructor vacio*/
    public ListaNinos(){

    }
    
    public List<Ninos> findAll(){
        return this.ninosFacade.findAll();
    }

    public Ninos getS() {
        return s;
    }

    public void setS(Ninos s) {
        this.s = s;
    }
    
    public String crearNino(){
        return "registrarnino.xhtml";
    }
    
    public String add(){
        this.ninosFacade.create(this.s);
        this.s= new Ninos();
        return "listaninos.xhtml";
    }
    
    public void delete(Ninos s){
        this.ninosFacade.remove(s);
    }
    
    public String edit(Ninos s){
        this.s = s;
        return "perfilnino.xhtml";
    }
    
    public String edit(){
        this.ninosFacade.edit(this.s);
        return "listaninos.xhtml";
    }
}
