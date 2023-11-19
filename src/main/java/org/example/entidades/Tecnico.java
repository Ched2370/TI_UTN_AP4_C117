package org.example.entidades;

public class Tecnico {
  private int id_tecnico;
  private String apellido;
  private String nombre;

    public Tecnico(){

    }

    public Tecnico(int id_tecnico, String apellido, String nombre) {
        this.id_tecnico = id_tecnico;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id_tecnico=" + id_tecnico +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
