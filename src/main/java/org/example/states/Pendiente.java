package org.example.states;

import jakarta.persistence.Embeddable;
import org.example.entidades.Incidente;

@Embeddable
public class Pendiente implements EstadoIncidente {

    @Override
    public void resolverIncidente(Incidente incidente) {
        incidente.setResuelto(true);
        System.out.println("** El incidente ha sido RESUELTO **");
    }

    @Override
    public void iniciarIncidente(Incidente incidente) {
        System.out.println("** El incidente está PENDIENTE **");
    }

}
