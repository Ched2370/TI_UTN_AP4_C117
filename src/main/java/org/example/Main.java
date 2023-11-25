package org.example;

import java.util.List;
import java.util.NoSuchElementException;
import org.example.accesodatos.EspecialidadDAO;
import org.example.accesodatos.IncidenteDAO;
import org.example.accesodatos.TecnicoDAO;
import org.example.entidades.Especialidad;
import org.example.entidades.Incidente;
import org.example.entidades.Tecnico;

public class Main {

    public static void main(String[] args) {

        // Recursos necesarios antes de hacer las pruebas
        TecnicoDAO datosTec = new TecnicoDAO();
        IncidenteDAO datosIncidentes = new IncidenteDAO();
        EspecialidadDAO datosEspecialidad = new EspecialidadDAO();

        List<Tecnico> tecnicos = datosTec.getListaTecnicos();
        List<Incidente> incidentes = datosIncidentes.getListaIncidentes();
        List<Especialidad> especialidades = datosEspecialidad.getListaEspecialidades();

        // - #1: Quién(es) fue el(los) técnico(s) con más incidentes resueltos en los últimos N días
        try {
            int dias = 4;
            List<Tecnico> listaTecnicos = Logica.tecnicosConMasIncidentesResueltos_enUltimosXdias(dias, incidentes);

            System.out.println("");
            System.out.println("*******************************************");

            System.out.println("Se encontraron " + listaTecnicos.size() + " resultados.");
            for (Tecnico tecnico : listaTecnicos) {
                System.out.println(" - Técnico ID #: " + tecnico.getId_tecnico());
            }
        } catch (NoSuchElementException e) {
            System.out.println("No hay resultados.");
        }

    }

}
