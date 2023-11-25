package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Operador;

public class OperadorDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Operador> getListaOperadores() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Operador> operadores = em.createQuery("SELECT t FROM Operador t", Operador.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return operadores;
    }

    public void agregarOperador(Operador operador) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(operador);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarOperador(int id_operador) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Operador operador = em.find(Operador.class, id_operador);

        if (operador != null) {
            em.remove(operador);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarOperador(Operador operador) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(operador);
        em.getTransaction().commit();
        em.close();

    }

    public Operador buscarOperador(int id_operador) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Operador operador = em.find(Operador.class, id_operador);
        em.getTransaction().commit();
        em.close();

        return operador;

    }

}
