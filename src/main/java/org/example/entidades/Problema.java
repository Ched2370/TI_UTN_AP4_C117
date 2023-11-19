package org.example.entidades;
public class Problema {
 private int id_Problema;
 private String descripcion;
 private Cliente cliente;
 public Problema(){

 }

    public Problema(int id_Problema, String descripcion, Cliente cliente) {
        this.id_Problema = id_Problema;
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public int getId_Problema() {
        return id_Problema;
    }

    public void setId_Problema(int id_Problema) {
        this.id_Problema = id_Problema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Problema{" +
                "id_Problema=" + id_Problema +
                ", descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}


