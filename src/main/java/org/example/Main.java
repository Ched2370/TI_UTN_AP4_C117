package org.example;

import java.util.List;
import java.util.NoSuchElementException;
import org.example.accesodatos.EspecialidadDAO;
import org.example.accesodatos.IncidenteDAO;
import org.example.entidades.Especialidad;
import org.example.entidades.Incidente;
import org.example.entidades.Tecnico;
import org.example.logica.Logica;

public class Main {

    public static void main(String[] args) {

// Recursos necesarios antes de hacer las pruebas
        IncidenteDAO datosIncidentes = new IncidenteDAO();
        EspecialidadDAO datosEspecialidad = new EspecialidadDAO();
        Especialidad especialidad = datosEspecialidad.buscarEspecialidad(3);

        List<Incidente> incidentes = datosIncidentes.getListaIncidentes();

        // - #1: Quién(es) fue el(los) técnico(s) con más incidentes resueltos en los últimos N días
        try {
            int dias = 5;
            List<Tecnico> listaTecnicos = Logica.tecnicosConMasIncidentesResueltos_enUltimosXdias(dias, incidentes);

            System.out.println("");
            System.out.println("** TECNICO(S) CON MAS INCIDENTES RESUELTOS **");
            System.out.println("Se encontraron " + listaTecnicos.size() + " resultados.");
            listaTecnicos.forEach(tecnico -> System.out.println(" - Técnico ID #: " + tecnico.getId_tecnico()));

        } catch (NoSuchElementException e) {

            System.out.println("");
            System.out.println("** TECNICO(S) CON MAS INCIDENTES RESUELTOS **");
            System.out.println("No hay resultados.");
        }

        // - #2: Quién(es) fue el(los) técnico(s) con más incidentes resueltos en los últimos N días según una especialidad
        try {
            int dias = 10;
            List<Tecnico> listaTecnicos = Logica.tecnicosConMasIncidentesResueltos_enUltimosXdias_Especialidades(dias, incidentes, especialidad);

            System.out.println("");
            System.out.println("** TECNICO(S) CON MAS INCIDENTES RESUELTOS SEGUN ESPECIALIDAD **");

            System.out.println("Se encontraron " + listaTecnicos.size() + " resultados.");
            listaTecnicos.forEach(tecnico -> System.out.println(" - Técnico ID #: " + tecnico.getId_tecnico()));

        } catch (NoSuchElementException e) {

            System.out.println("");
            System.out.println("** TECNICO(S) CON MAS INCIDENTES RESUELTOS SEGUN ESPECIALIDAD **");
            System.out.println("No hay resultados.");
        }

        // - #3: Quién(es) fue(ron) el(los) técnico(s) que más rápido resolvió los incidentes
        System.out.println("");
        System.out.println("** TECNICO(S) MAS RAPIDOS EN RESOLVER INCIDENTES **");

        List<Tecnico> listaTecnicos = Logica.tecnicoMasRapido(incidentes);

        listaTecnicos.forEach(tecnico -> System.out.println(" - Técnico ID #: " + tecnico.getId_tecnico()));
    }
}
