/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Edu Ruiz
 */

@Named(value = "controladorRegistrarNino")
@SessionScoped
public class ControladorRegistrarNino implements Serializable {
    private Ninos nino;

    public void setNino(Ninos nino) {
        this.nino = nino;
    }
    public Ninos getNino() {
        return nino;
    }
    
    public Long getId() {
        return nino.getId();
    }

    public String getNombre() {
        return this.nino.getNombre();
    }

    public String getApellidos() {
        return this.nino.getApellidos();
    }

    public String getEstado() {
        return this.nino.getEstado();
    }
    
public String getBeca() {
        return this.nino.getBeca();
    }

    public String getSexo() {
        return this.nino.getSexo();
    }

    public String getAgente() {
        return this.nino.getAgente();
    }

    public String getFoto() {
        return this.nino.getFoto();
    }

    public Date getFechaNac() {
        return this.nino.getFechaNac();
    }

    public Date getFechaAlta() {
        return this.nino.getFechaAlta();
    }

    public Date getFechaBaja() {
        return this.nino.getFechaBaja();
    }

    public String getProyecto() {
        return this.nino.getProyecto();
    }

    public String getGradoCurso() {
        return this.nino.getGradoCurso();
    }

    public String getComunidadProcedencia() {
        return this.nino.getComunidadProcedencia();
    }

    public String getColoniaActual() {
        return this.nino.getColoniaActual();
    }

    public String getObservaciones() {
        return this.nino.getObservaciones();
    }
    
    public String ListaSocios(){
        return "listasocios.xhtml";
    }
    
    public String ListaNinos(){
        return "listaninos.xhtml";
    }
    
    public String NinosApadrinados(){
        return "listaninosapadrinados.xhtml";
    }
    
    public String Cuotas(){
        return "listacuotas.xhtml";
    }
    
    public String MisDatos(){
        return "socio.xhtml";
    }
    
    public String ListaEnvios(){
        return "envio.xhtml";
    }
    
    public String crear(){
        return "listaninos.xhtml";
    }
    
    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControladorRegistrarNino() {
    }
}

