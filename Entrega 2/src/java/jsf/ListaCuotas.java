/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Cuota;
import acoes.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sergio
 */

    @Named(value = "ListaCuotas")
    @SessionScoped
public class ListaCuotas implements Serializable {
        private Cuota [] cuotas;
        //...
}
