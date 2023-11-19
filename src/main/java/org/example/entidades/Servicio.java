package org.example.entidades;

public class Servicio {
private int id_servicio;
private String descripcion;
public Servicio(){
    }

    public Servicio(Integer id_servicio, String descripcion) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

