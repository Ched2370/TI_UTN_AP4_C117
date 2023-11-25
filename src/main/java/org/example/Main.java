package org.example;

import java.util.List;
import org.example.accesodatos.EspecialidadDAO;
import org.example.entidades.Especialidad;
import org.example.entidades.Tecnico;

public class Main {

    public static void main(String[] args) {

        // Quién(es) fue el(los) técnico(s) con más incidentes resueltos en los últimos N días
        int dias = 4;
        List<Tecnico> tecnicos = Logica.tecnicosConMasIncidentesResueltos_enUltimosXdias(dias);

        System.out.println("");
        System.out.println("*******************************************");
        if (tecnicos.size() != 0) {

            System.out.println("Técnicos que han resuelto la mayor cantidad de "
                    + "incidentes en los últimos " + dias + " días:");

            for (Tecnico tecnico : tecnicos) {
                System.out.println("#" + tecnico.getId_tecnico() + " "
                        + tecnico.getNombre() + " " + tecnico.getApellido());
            }
        } else {
            System.out.println("No se han encontrado técnicos.");
        }
    }

}
