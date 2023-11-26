package org.example.states;

import jakarta.persistence.Embeddable;
import org.example.entidades.Incidente;

@Embeddable
public class Resuelto implements EstadoIncidente {

    @Override
    public void resolverIncidente(Incidente incidente) {
        System.out.println("** El incidente ya está RESUELTO **");
    }

    @Override
    public void iniciarIncidente(Incidente incidente) {
        incidente.setResuelto(false);
        System.out.println("** El incidente ha sido iniciado como PENDIENTE");
    }

}
