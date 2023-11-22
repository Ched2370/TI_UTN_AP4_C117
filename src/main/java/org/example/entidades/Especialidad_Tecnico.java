package org.example.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidad_tecnico")
public class Especialidad_Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad_tecnico")
    private int id_especilidad_tecnico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    public Especialidad_Tecnico() {
    }

    public Especialidad_Tecnico(Especialidad especialidad, Tecnico tecnico) {
        this.especialidad = especialidad;
        this.tecnico = tecnico;
    }

    public Especialidad_Tecnico(int id_especilidad_tecnico, Especialidad especialidad, Tecnico tecnico) {
        this.id_especilidad_tecnico = id_especilidad_tecnico;
        this.especialidad = especialidad;
        this.tecnico = tecnico;
    }

    public int getId_especilidad_tecnico() {
        return id_especilidad_tecnico;
    }

    public void setId_especilidad_tecnico(int id_especilidad_tecnico) {
        this.id_especilidad_tecnico = id_especilidad_tecnico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

}
