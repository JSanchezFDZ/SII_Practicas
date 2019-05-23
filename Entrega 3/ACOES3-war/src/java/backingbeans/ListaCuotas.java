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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import modelos.CuotaFacade;

/**
 *
 * @author Jesús Correa Conejero
 */

    @Named(value = "ListaCuotas")
    @SessionScoped
public class ListaCuotas implements Serializable {
       @EJB
    private CuotaFacade cuotasFacade;
    private Cuota c = new Cuota();

    
    /*Constructor vacio*/
    public ListaCuotas(){

    }
    
    public List<Cuota> findAll(){
        return this.cuotasFacade.findAll();
    }

    public Cuota getC() {
        return c;
    }

    public void setC(Cuota c) {
        this.c = c;
    }
    
    public String crearCuota(){
        return "insertarCuota.xhtml";
    }
    
    public String add(){
        this.cuotasFacade.create(this.c);
        return "listacuotas.xhtml";
    }
    
    public void delete(Cuota c){
        this.cuotasFacade.remove(c);
    }
    
    public String edit(Cuota c){
        this.c = c;
        return "modificarCuota.xhtml";
    }
    
    public String edit(){
        this.cuotasFacade.edit(this.c);
        return "listacuotas.xhtml";
    }
    
        
        
        
}