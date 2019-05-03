/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Apadrinamiento;
import acoes.Envio;
import acoes.Ninos;
import acoes.Socios;
import acoes.Usuario;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sergio
 */
public class DatosPrueba {
    private Usuario usuario;
    private Socios socio;
    private Envio envio;
    private Ninos nino;
    private Apadrinamiento padrino;


    public DatosPrueba() {
        usuario = new Usuario("pepe","70001", "asdf", Usuario.Rol.SOCIO);
        socio = new Socios(" Pepe "," Gutierrez ", new Long(70001)," Soltero ", " C/SinNombre nº 5","Narnia ",00000,"El baticano",
        "111 222 333", "pepeG@gmail.com", "", "Activo", new Date(118, 5, 3), new Date(000, 0, 0), "", usuario);
        padrino = new Apadrinamiento(Long.parseLong("111"), null, socio, envio);
        envio = new Envio(Long.parseLong("74"), padrino, null, null, "Sin Obersaviones");
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public Socios getSocio() {
        return socio;
    }

    public Envio getEnvio() {
        return envio;
    }

    public Ninos getNino() {
        return nino;
    }

    public Apadrinamiento getPadrino() {
        return padrino;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public void setNino(Ninos nino) {
        this.nino = nino;
    }

    public void setPadrino(Apadrinamiento padrino) {
        this.padrino = padrino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.usuario);
        hash = 47 * hash + Objects.hashCode(this.socio);
        hash = 47 * hash + Objects.hashCode(this.envio);
        hash = 47 * hash + Objects.hashCode(this.nino);
        hash = 47 * hash + Objects.hashCode(this.padrino);
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
        final DatosPrueba other = (DatosPrueba) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.socio, other.socio)) {
            return false;
        }
        if (!Objects.equals(this.envio, other.envio)) {
            return false;
        }
        if (!Objects.equals(this.nino, other.nino)) {
            return false;
        }
        if (!Objects.equals(this.padrino, other.padrino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatosPrueba{" + "usuario=" + usuario + ", socio=" + socio + ", envio=" + envio + ", nino=" + nino + ", padrino=" + padrino + '}';
    }
    
    
}
