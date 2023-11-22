package org.example.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private int id_especialidad;

    @Column(name = "nombre_especialidad")
    private String nombre_especialidad;

    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Especialidad() {
    }

    public Especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public Especialidad(int id_especialidad, String nombre_especialidad) {
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

}
