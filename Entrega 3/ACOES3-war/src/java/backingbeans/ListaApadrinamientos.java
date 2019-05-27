/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelos.ApadrinamientoFacade;

/**
 *
 * @author Salva
 */
    @Named(value = "ListaApadrinamientos")
    @RequestScoped
    
public class ListaApadrinamientos implements Serializable {
    @EJB
    private ApadrinamientoFacade apadrinamientoFacade;
    private Apadrinamiento s = new Apadrinamiento();

    
    /*Constructor vacio*/
    public ListaApadrinamientos(){

    }
    
    public List<Apadrinamiento> findAll(){
        return this.apadrinamientoFacade.findAll();
    }

    public Apadrinamiento getS() {
        return s;
    }

    public void setS(Apadrinamiento s) {
        this.s = s;
    }
    
    public String crearApadrinamiento(){
        return "insertarApadrinamiento.xhtml";
    }
    
    public String add(){
        this.apadrinamientoFacade.create(this.s);
        this.s = new Apadrinamiento();
        return "listaninosapadrinados.xhtml";
    }
    
    public void delete(Apadrinamiento s){
        this.apadrinamientoFacade.remove(s);
    }
    
    public String edit(Apadrinamiento s){
        this.s = s;
        return "modificarApadrinamiento.xhtml";
    }
    
    public String edit(){
        this.apadrinamientoFacade.edit(this.s);
        return "listaninosapadrinados.xhtml";
    }
}
