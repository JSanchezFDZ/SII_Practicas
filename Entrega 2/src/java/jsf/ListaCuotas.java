/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Cuota;
import acoes.Socios;
import acoes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jesús Correa Conejero
 */

    @Named(value = "ListaCuotas")
    @SessionScoped
public class ListaCuotas implements Serializable {
        private List<Cuota> cuotas;
        private List<Socios> socios;
        private Cuota cuota;
        
        public ListaCuotas(){
            cuotas = new ArrayList<Cuota>();
            socios = new ArrayList<Socios>();
            socios.add(new Socios("pepe", (long) 70001));
            //socios.add(new Socios("Manuel", (long) 70002));
            cuotas.add(new Cuota((long) 1, "Estándar", "Mensual", 20, socios));
            cuotas.add(new Cuota((long) 2, "Básica", "Semanal", 5, socios));
            cuota = new Cuota(Long.MIN_VALUE, null, null, 0, null);
        }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
    
    public String añadirCuotaALista(String nombre, String tipo, long apor){
        cuotas.add(new Cuota((long) 3, nombre, tipo, apor, null));
        return "listacuotas.xhtml";
    }
    
        public int getNumeroCuotas(){
        int i;
        for (i=0;i<cuotas.size();i++){
            i++;
        }
        return i;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
    
    public String insertarCuota() {
        //setModo(Modo.INSERTAR);
        return "insertarCuota.xhtml";
    }
    
    public String eliminarCuota() {
        return "listacuotas.xhtml";
    }

    public List<Socios> getSocios() {
        return socios;
    }

    public void setSocios(List<Socios> socios) {
        this.socios = socios;
    }
        
        
}