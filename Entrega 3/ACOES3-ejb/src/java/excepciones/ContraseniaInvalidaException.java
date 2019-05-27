/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Jesús Sánchez
 */
public class ContraseniaInvalidaException extends AcoesException{

    public ContraseniaInvalidaException() {
    }

    public ContraseniaInvalidaException(String msg) {
        super(msg);
    }
    
}
