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
import modelos.EnvioFacade;

/**
 *
 * @author Sergio
 */
@Named(value = "ListaEnvios")
@RequestScoped

public class ListaEnvios implements Serializable{
    @EJB
    private EnvioFacade enviosFacade;
    @EJB
    private ApadrinamientoFacade apadrinamientoFacade;    
    private Envio e = new Envio();
    private Apadrinamiento apadr;
    private List<Envio> listaEnvios;

    public ListaEnvios() {
    }
    
    public List<Envio> findAll(){
        return this.enviosFacade.findAll();
    }

    public String crearEnvio(){
        return "registrarenvio.xhtml";
    }
    
    public EnvioFacade getEnviosFacade() {
        return enviosFacade;
    }

    public void setEnviosFacade(EnvioFacade enviosFacade) {
        this.enviosFacade = enviosFacade;
    }

    public Envio getE() {
        return e;
    }

    public void setE(Envio e) {
        this.e = e;
    }
    
    public String add(Long codApad){
        listaEnvios = enviosFacade.findAll();
        listaEnvios.add(e);
        
        apadr = apadrinamientoFacade.find(codApad);
        apadr.setCodEnvio(listaEnvios);
        
        this.enviosFacade.create(this.e);
        this.e = new Envio();
        apadrinamientoFacade.edit(apadr);
        return "listaenvios.xhtml";
    }
    
    public void delete(Envio e){
        this.enviosFacade.remove(e);
    }
    
    
    public String edit(Envio e){
        this.e = e;
        return "modificarEnvio.xhtml";
    }
    
    public String edit(){
        this.enviosFacade.edit(this.e);
        return "listaenvios.xhtml";
    }
    
    
    /* PARA EL PADRINO, PERMITE VER TODOS LOS ENVIOS DADOS UN ID DE PADRINO
     public ArrayList<Envio> getEnviosPadrino(){
        if(padrino.getCodApadrinamiento()==null) return null;
        Long codigoPadrino = padrino.getCodApadrinamiento();
        ArrayList<Envio> aux = new ArrayList<>(envios.size());
        
        for(int i=0; i<envios.size();i++){
            if(codigoPadrino.equals(envios.get(i).getCodApadrinamiento().getCodApadrinamiento())){
                aux.add(envios.get(i));
            }
        }
        return aux;
    }

*/
}
