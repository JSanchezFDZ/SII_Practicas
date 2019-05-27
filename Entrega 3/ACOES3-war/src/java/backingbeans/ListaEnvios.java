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
    private Envio e = new Envio();

    

    /*public ListaEnvios() {
        envios = new ArrayList<>();
        DatosPrueba test = new DatosPrueba();   //CLASE QUE CONTIENE EJEMPLOS DE CADA ENTIDAD!
        padrino = test.getPadrino();
        envios.add(new Envio(Long.parseLong("1"), test.getPadrino(), new Date(000, 0, 0), new Date(004, 0, 0), "N/A"));
         envios.add(new Envio(Long.parseLong("2"), test.getPadrino(), new Date(000, 3, 0), new Date(003, 0, 0), "N/A"));
         envios.add(new Envio(Long.parseLong("3"), test.getPadrino(), new Date(000, 4, 1), new Date(001, 0, 0), "N/A"));

       }*/

    /*
    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public Apadrinamiento getPadrino() {
        return padrino;
    }

    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }

    public void setPadrino(Apadrinamiento padrino) {
        this.padrino = padrino;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.envios);
        hash = 67 * hash + Objects.hashCode(this.padrino);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaEnvios other = (ListaEnvios) obj;
        if (!Objects.equals(this.envios, other.envios)) {
            return false;
        }
        if (!Objects.equals(this.padrino, other.padrino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListaEnvios{" + "envios=" + envios + ", padrino=" + padrino + '}';
    }

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
    
    public String add(){
        this.enviosFacade.create(this.e);
        this.e = new Envio();
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
