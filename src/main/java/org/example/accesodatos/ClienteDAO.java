package org.example.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.example.entidades.Cliente;

public class ClienteDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public List<Cliente> getListaClientes() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Cliente> clientes = em.createQuery("SELECT t FROM Cliente t", Cliente.class)
                .getResultList();

        em.getTransaction().commit();
        em.close();

        return clientes;
    }

    public void agregarCliente(Cliente cliente) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();

    }

    public void borrarCliente(int cuit) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, cuit);

        if (cliente != null) {
            em.remove(cliente);
        }

        em.getTransaction().commit();
        em.close();

    }

    public void actualizarCliente(Cliente cliente) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(cliente);
        em.getTransaction().commit();
        em.close();

    }

    public Cliente buscarCliente(int cuit) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, cuit);
        em.getTransaction().commit();
        em.close();

        return cliente;

    }

}
