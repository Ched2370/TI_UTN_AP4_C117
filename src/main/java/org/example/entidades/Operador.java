package org.example.entidades;

public class Operador {
    private int id_operador;
    private String nombre;
    public Operador(){

    }

    public Operador(int id_operador, String nombre) {
        this.id_operador = id_operador;
        this.nombre = nombre;
    }

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id_operador=" + id_operador +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
