/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Usuario;
import excepciones.AcoesException;
import javax.ejb.Local;

/**
 *
 * @author Jesús Sánchez
 */
@Local
public interface Negocio {
    public void compruebaLogin(Usuario u) throws AcoesException;
    public Usuario refrescarUsuario(Usuario u) throws AcoesException;
/*    public void modificar(Contacto c) throws AcoesException;
    public void insertar(Contacto c)throws AcoesException;
    public void eliminarContacto(Contacto c)throws AcoesException;*/
    // Crear metodos para crear niño, eliminar, modificar y con todos.
}

