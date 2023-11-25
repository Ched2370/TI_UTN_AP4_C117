package org.example;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.entidades.Incidente;
import org.example.entidades.Tecnico;

public class Logica {

    // Método para parsear un Date a LocalDate
    private static LocalDate toLocalDate(Date fecha) {

        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public static List<Tecnico> tecnicosConMasIncidentesResueltos_enUltimosXdias(int dias, List<Incidente> incidentes) {

        // Declaramos la fecha actual como límite y le restamos los días que pasamos como atributo
        LocalDate fechaLimite = LocalDate.now().minusDays(dias);
        
        // Guardamos los técnicos que resolvieron incidentes y contamos la cantidad de incidentes resueltos por cada técnico
        Map<Tecnico, Long> tecnicos_CantIncidentes = incidentes.stream()
                .filter(Incidente::isResuelto)
                .filter(incidente -> toLocalDate(incidente.getFecha_finalizado()).isAfter(fechaLimite))
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

        // Buscamos la mayor cantidad de incidentes resueltos
        long maxCantidad = Collections.max(tecnicos_CantIncidentes.values());

        // Filtramos y retornamos la lista de técnicos segun la mayor cantidad de incidentes resueltos
        return tecnicos_CantIncidentes.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCantidad)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
