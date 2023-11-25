package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Problema;

public class ProblemaDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Problema> getListaProblemas() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Problema> problemas = em.createQuery("SELECT t FROM Problema t", Problema.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return problemas;
    }

    public void agregarProblema(Problema problema) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(problema);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarProblema(int id_problema) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Problema problema = em.find(Problema.class, id_problema);

        if (problema != null) {
            em.remove(problema);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarProblema(Problema problema) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(problema);
        em.getTransaction().commit();
        em.close();

    }

    public Problema buscarProblema(int id_problema) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Problema problema = em.find(Problema.class, id_problema);
        em.getTransaction().commit();
        em.close();

        return problema;

    }

}
