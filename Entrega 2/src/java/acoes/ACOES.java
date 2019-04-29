/*
 * Sistemas de Información para Intenet
 * Grupo G
 * Universidad de Málaga
 */
package acoes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jesús
 */
public class ACOES {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        EntityManager em = emf.createEntityManager();
        /*
        EntityTransaction tx = em.getTransaction();
        Ninos nino1 = new Ninos();
        nino1.setNombre("Pepe");
        nino1.setApellidos("Lopez");;
        tx.begin();
        em.persist(nino1);
        tx.commit();*/
        
        em.close();
        emf.close();
    }
    
}
