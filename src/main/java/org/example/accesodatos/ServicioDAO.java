package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Servicio;

public class ServicioDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Servicio> getListaServicios() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Servicio> servicios = em.createQuery("SELECT t FROM Servicio t", Servicio.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return servicios;
    }

    public void agregarServicio(Servicio servicio) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(servicio);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarServicio(int id_servicio) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Servicio servicio = em.find(Servicio.class, id_servicio);

        if (servicio != null) {
            em.remove(servicio);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarServicio(Servicio servicio) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(servicio);
        em.getTransaction().commit();
        em.close();

    }

    public Servicio buscarServicio(int id_servicio) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Servicio servicio = em.find(Servicio.class, id_servicio);
        em.getTransaction().commit();
        em.close();

        return servicio;

    }

}
