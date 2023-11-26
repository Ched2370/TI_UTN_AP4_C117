package org.example.states;

import jakarta.persistence.Embeddable;
import org.example.entidades.Incidente;

@Embeddable
public interface EstadoIncidente {

    public void resolverIncidente(Incidente incidente);

    public void iniciarIncidente(Incidente incidente);

}
