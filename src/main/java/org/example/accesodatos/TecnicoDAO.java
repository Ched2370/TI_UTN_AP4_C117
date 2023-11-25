package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import java.util.List;
import org.example.entidades.Tecnico;

public class TecnicoDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Tecnico> getListaTecnicos() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Tecnico> tecnicos = em.createQuery("SELECT t FROM Tecnico t", Tecnico.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return tecnicos;
    }

    public void agregarTecnico(Tecnico tecnico) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(tecnico);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarTecnico(int id_tecnico) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Tecnico tecnico = em.find(Tecnico.class, id_tecnico);

        if (tecnico != null) {
            em.remove(tecnico);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarTecnico(Tecnico tecnico) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(tecnico);
        em.getTransaction().commit();
        em.close();

    }

    public Tecnico buscarTecnico(int id_tecnico) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Tecnico tecnico = em.find(Tecnico.class, id_tecnico);
        em.getTransaction().commit();
        em.close();

        return tecnico;

    }

}
