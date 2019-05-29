/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelos.ApadrinamientoFacade;
import modelos.NinosFacade;
import modelos.SociosFacade;

/**
 *
 * @author Salva
 */
    @Named(value = "ListaApadrinamientos")
    @RequestScoped
    
public class ListaApadrinamientos implements Serializable {
    @EJB
    private ApadrinamientoFacade apadrinamientoFacade;
    @EJB
    private NinosFacade ninosFacade;
    @EJB
    private SociosFacade sociosFacade;    
    private Apadrinamiento s = new Apadrinamiento();
    private List<Apadrinamiento> listaApadrinamiento;
    private Ninos nino;
    private Socios socio;

    
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
    
    public String add(Long idNino, Long idSocio){
        nino = ninosFacade.find(idNino);
        nino.setCodApadrinamiento(s);
        
        listaApadrinamiento = apadrinamientoFacade.findAll();
        listaApadrinamiento.add(s);
        socio = sociosFacade.find(idSocio);
        socio.setApadr(listaApadrinamiento);
        
        this.apadrinamientoFacade.create(this.s);
        this.s = new Apadrinamiento();
        ninosFacade.edit(nino);
        sociosFacade.edit(socio);
        return "listaninosapadrinados.xhtml";
    }
    
    public void delete(Apadrinamiento s){
        this.apadrinamientoFacade.remove(s);
    }
    
    public String edit(Apadrinamiento s){
        this.s = s;
        return "modificarApadrinamiento.xhtml";
    }
    
    public String editar(Long idNino){
        nino = ninosFacade.find(s.getCodNino().getId());
        nino.setCodApadrinamiento(null);
        nino = ninosFacade.find(idNino);
        nino.setCodApadrinamiento(s);
        
        this.apadrinamientoFacade.edit(this.s);
        ninosFacade.edit(nino);
        return "listaninosapadrinados.xhtml";
    }
    
    public Long getAnterior(Long idNinoAnterior) {
        return idNinoAnterior;
    }
    
}
