/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Apadrinamiento;
import acoes.Envio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Sergio
 */
@Named(value = "ListaEnvios")
@SessionScoped
public class ListaEnvios implements Serializable{
    private ArrayList<Envio> envios;
    private Apadrinamiento padrino;

    public ListaEnvios() {
        envios = new ArrayList<>();
        DatosPrueba test = new DatosPrueba();   //CLASE QUE CONTIENE EJEMPLOS DE CADA ENTIDAD!
        padrino = test.getPadrino();
        envios.add(new Envio(Long.parseLong("1"), test.getPadrino(), new Date(000, 0, 0), new Date(004, 0, 0), "N/A"));
         envios.add(new Envio(Long.parseLong("2"), test.getPadrino(), new Date(000, 3, 0), new Date(003, 0, 0), "N/A"));
         envios.add(new Envio(Long.parseLong("3"), test.getPadrino(), new Date(000, 4, 1), new Date(001, 0, 0), "N/A"));
    }


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
    
    
}
