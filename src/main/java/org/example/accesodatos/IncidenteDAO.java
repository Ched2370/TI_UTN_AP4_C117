package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Incidente;

public class IncidenteDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Incidente> getListaIncidentes() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Incidente> incidentes = em.createQuery("SELECT t FROM Incidente t", Incidente.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return incidentes;
    }

    public void agregarIncidente(Incidente incidente) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(incidente);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarIncidente(int id_incidente) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Incidente incidente = em.find(Incidente.class, id_incidente);

        if (incidente != null) {
            em.remove(incidente);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarIncidente(Incidente incidente) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(incidente);
        em.getTransaction().commit();
        em.close();

    }

    public Incidente buscarIncidente(int id_incidente) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Incidente incidente = em.find(Incidente.class, id_incidente);
        em.getTransaction().commit();
        em.close();

        return incidente;

    }

}
