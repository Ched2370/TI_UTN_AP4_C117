package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Especialidad;

public class EspecialidadDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Especialidad> getListaEspecialidades() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Especialidad> especialidades = em.createQuery("SELECT t FROM Especialidad t", Especialidad.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return especialidades;
    }

    public void agregarEspecialidad(Especialidad especialidad) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(especialidad);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarEspecialidad(int id_especialidad) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Especialidad especialidad = em.find(Especialidad.class, id_especialidad);

        if (especialidad != null) {
            em.remove(especialidad);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarEspecialidad(Especialidad especialidad) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(especialidad);
        em.getTransaction().commit();
        em.close();

    }

    public Especialidad buscarEspecialidad(int id_especialidad) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Especialidad especialidad = em.find(Especialidad.class, id_especialidad);
        em.getTransaction().commit();
        em.close();

        return especialidad;

    }

}
