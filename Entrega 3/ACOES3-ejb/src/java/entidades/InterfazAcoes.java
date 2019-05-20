
package entidades;


import excepciones.AcoesException;
import javax.ejb.Local;

/**
 *
 * @author francis
 */
@Local
public interface InterfazAcoes {
   public void crearAdmin();
   public void insertar(Socios s) throws AcoesException;
}

