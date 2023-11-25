package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Contrato;

public class ContratoDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Contrato> getListaContratos() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Contrato> contratos = em.createQuery("SELECT t FROM Contrato t", Contrato.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return contratos;
    }

    public void agregarContrato(Contrato contrato) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(contrato);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarContrato(int id_contrato) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Contrato contrato = em.find(Contrato.class, id_contrato);

        if (contrato != null) {
            em.remove(contrato);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarContrato(Contrato contrato) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(contrato);
        em.getTransaction().commit();
        em.close();

    }

    public Contrato buscarContrato(int id_contrato) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Contrato contrato = em.find(Contrato.class, id_contrato);
        em.getTransaction().commit();
        em.close();

        return contrato;

    }

}
