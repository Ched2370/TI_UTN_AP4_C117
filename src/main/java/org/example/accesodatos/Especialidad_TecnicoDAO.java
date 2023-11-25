
package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Especialidad_Tecnico;

public class Especialidad_TecnicoDAO {
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Especialidad_Tecnico> getListaEsp_Tec() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Especialidad_Tecnico> esp_tecLista = em.createQuery("SELECT t FROM Especialidad_Tecnico t", Especialidad_Tecnico.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return esp_tecLista;
    }

    public void agregarEsp_Tec(Especialidad_Tecnico esp_tec) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(esp_tec);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarEsp_Tec(int id_especialidad_tecnico) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Especialidad_Tecnico esp_tec = em.find(Especialidad_Tecnico.class, id_especialidad_tecnico);

        if (esp_tec != null) {
            em.remove(esp_tec);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarEsp_Tec(Especialidad_Tecnico esp_tec) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(esp_tec);
        em.getTransaction().commit();
        em.close();

    }

    public Especialidad_Tecnico buscarEsp_Tec(int id_especialidad_tecnico) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Especialidad_Tecnico esp_tec = em.find(Especialidad_Tecnico.class, id_especialidad_tecnico);
        em.getTransaction().commit();
        em.close();

        return esp_tec;

    }
    
}
