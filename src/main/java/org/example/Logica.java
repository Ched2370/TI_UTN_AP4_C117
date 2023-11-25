package org.example;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.accesodatos.IncidenteDAO;
import org.example.accesodatos.TecnicoDAO;
import org.example.entidades.Incidente;
import org.example.entidades.Tecnico;

public class Logica {

    // Método para parsear un Date a LocalDate
    private static LocalDate toLocalDate(Date fecha) {

        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public static List<Tecnico> tecnicosConMasIncidentesResueltos_enUltimosXdias(int dias) {

        TecnicoDAO datosTec = new TecnicoDAO();
        IncidenteDAO datosIncidentes = new IncidenteDAO();

        // Declaramos la fecha actual como límite y le restamos los días que pasamos como atributo
        LocalDate fechaLimite = LocalDate.now().minusDays(dias);

        // Se obtiene una lista de tecnicos
        // Se obtiene una lista de incidentes filtrada por resueltos y dentro de un rango de fechas
        List<Tecnico> listaTecnicos = datosTec.getListaTecnicos();
        List<Incidente> listaIncidentes = datosIncidentes.getListaIncidentes().stream()
                .filter(incidente -> incidente.isResuelto() && toLocalDate(incidente.getFecha_finalizado()).isAfter(fechaLimite))
                .collect(Collectors.toList());

        // Mapa para registrar la cantidad de incidentes resueltos por cada técnico y encontramos el valor máximo
        Map<Tecnico, Long> incidentesPorTecnico = listaIncidentes.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
        long maxIncidentes = incidentesPorTecnico.values().stream()
                .max(Comparator.naturalOrder()).orElse(0L);

        List<Tecnico> tecnicosConMasIncidentes = incidentesPorTecnico.entrySet().stream()
                .filter(entry -> entry.getValue() == maxIncidentes)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Guardamos los técnico
        return tecnicosConMasIncidentes;

    }

}
