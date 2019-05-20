/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Socios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesús
 */
@Stateless
public class SociosFacade extends AbstractFacade<Socios> {
    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SociosFacade() {
        super(Socios.class);
    }
    
}
