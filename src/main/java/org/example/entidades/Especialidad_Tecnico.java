package org.example.entidades;

public class Especialidad_Tecnico {
    private int id_especilidad_tecnico;
    private Especialidad especialidad;
    private Tecnico tecnico;
public Especialidad_Tecnico(){
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

    @Override
    public String toString() {
        return "Especialidad_Tecnico{" +
                "id_especilidad_tecnico=" + id_especilidad_tecnico +
                ", especialidad=" + especialidad +
                ", tecnico=" + tecnico +
                '}';
    }
}