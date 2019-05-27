/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;


import entidades.*;
import excepciones.AcoesException;
import excepciones.ContraseniaInvalidaException;
import excepciones.CuentaInexistenteException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import negocio.Negocio;

/**
 *
 * @author Jesús Sánchez
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private Usuario usuario;

    @Inject
    private Negocio negocio;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String autenticar() {
        try {
            negocio.compruebaLogin(usuario);
            ctrl.setUsuario(negocio.refrescarUsuario(usuario));
            return "inicio.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
}
