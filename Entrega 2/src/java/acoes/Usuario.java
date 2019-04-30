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
    
    public enum Rol {
      ADMINISTRADOR,
      SOCIO
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;
    private String pass;
    private String user;
    private String apellidos;
    private String email;
    private Rol tipo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserID() {
        return UserID;
    }
    
    public Usuario()
    {
        
    }
    
    public Usuario (String usuario,String id,  String contrasenia, Rol tipo)
    {
        setUser(usuario);
        setID(Long.parseLong(id));
        setPass(contrasenia);
        setRol(tipo);
    }

    public String getPass() {
        return pass;
    }
    
    public void setID(Long n){
        UserID = n;
    }

    public String getUser() {
        return user;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(String usuario) {
        this.user = usuario;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(Rol rol) {
        this.tipo = rol;
    }

    public Rol getRol() {
        return tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.UserID);
        hash = 79 * hash + Objects.hashCode(this.user);
        hash = 79 * hash + Objects.hashCode(this.apellidos);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.tipo);
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
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
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
        return user;
    }
    
    
    
    
}
