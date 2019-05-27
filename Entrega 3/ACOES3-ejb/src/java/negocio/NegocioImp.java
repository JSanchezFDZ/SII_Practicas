/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Usuario;
import excepciones.AcoesException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Jesús Sánchez
 */
@Stateless
public class NegocioImp implements Negocio{
    
    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;

    @Override
    public void compruebaLogin(Usuario u) throws AcoesException {
        Usuario usu = em.find(Usuario.class, u.getUsuario());
     
        if (usu == null) {
            throw new AcoesException("La cuenta no existe.");
        }

        if (!usu.getPass().equals(u.getPass())) {
            throw new AcoesException("Contraseña incorrecta.");
        }
    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws AcoesException {
        compruebaLogin(u);
        Usuario usu = em.find(Usuario.class, u.getUsuario());
        System.out.println(usu.toString());
        em.refresh(usu);
        return usu;    }
    
}
