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
        ArrayList<Envio> aux = new ArrayList<>();
        if(envios==null) return null;
        for (Envio envio : envios) {
            if (envio.getCodApadrinamiento().equals(getPadrino().getCodApadrinamiento())) {
                aux.add(envio);
            }
        }
       
        return  aux;
    }
    
    
}
