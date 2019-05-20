/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Sergio
 */
@Entity
public class Usuario implements Serializable {
    
    public enum Rol {
      ADMINISTRADOR,
      SOCIO
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    private String usuario;
    private String pass;
    private String apellidos;
    private String email;
    @Enumerated
    private Rol rol;
    @OneToOne
    private Socios socio;

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public Usuario (String usuario, String contrasenia, Rol tipo)
    {
        this.usuario=usuario;
        this.pass=contrasenia;
        this.rol=tipo;
    }

    public Usuario(String usuario, String apellidos, String pass, String email, Rol tipo) {
        this.pass = pass;
        this.usuario = usuario;
        this.apellidos = apellidos;
        this.email = email;
        this.rol = tipo;
    }


    public Usuario() {
    }
    
    public Usuario(String cuenta, String pass, String apellidos, String email, Rol tipo, Usuario us) {
        this.pass = pass;
        this.usuario = cuenta;
        this.apellidos = apellidos;
        this.email = email;
        this.rol = tipo;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.pass);
        hash = 59 * hash + Objects.hashCode(this.apellidos);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.rol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.rol != other.rol) {
            return false;
        }
        return true;
    }





    @Override
    public String toString() {
        return usuario;
    }
    
    
    
    
}
