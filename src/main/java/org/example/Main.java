package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Date;
import org.example.entidades.Cliente;
import org.example.entidades.Contrato;
import org.example.entidades.Especialidad;
import org.example.entidades.Especialidad_Tecnico;
import org.example.entidades.Incidente;
import org.example.entidades.Operador;
import org.example.entidades.Problema;
import org.example.entidades.Servicio;
import org.example.entidades.Tecnico;

public class Main {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public static void main(String[] args) {

        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cliente cliente = new Cliente(987654, "Pepe SA 2");
        Tecnico tecnico = new Tecnico("Pepe 2", "Prueba 2");
        Especialidad especialidad = new Especialidad("Especialidad de prueba 2");
        Operador operador = new Operador("Operador Pepe 2");
        Problema problema = new Problema("Problema 2", cliente);
        Date date1 = new Date();
        Date date2 = new Date();
        Incidente incidente = new Incidente("incidente", date1, date2, false, tecnico, especialidad, operador, problema);
        
        
        em.persist(cliente);
        em.persist(tecnico);
        em.persist(especialidad);
        em.persist(operador);
        em.persist(problema);
        em.persist(incidente);
        tx.commit();

    }

}
