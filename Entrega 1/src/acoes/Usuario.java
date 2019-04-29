/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package acoes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sergio
 */
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;
    private String pass;
    private String nombre;
    private String apellidos;
    private String email;
    private int tipo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserID() {
        return UserID;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.UserID);
        hash = 31 * hash + Objects.hashCode(this.pass);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.apellidos);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + this.tipo;
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
        if (!Objects.equals(this.UserID, other.UserID)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "UserID=" + UserID + ", pass=" + pass + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", tipo=" + tipo + '}';
    }
    
    
    
    
}
