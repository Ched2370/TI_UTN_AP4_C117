package org.example.entidades;

public class Contrato {
    private int id_contrato;
    private String descripcion;
    private Cliente cliente;
    private Servicio servicio;

    public Contrato(){}

    public int getId_contrato() {
        return id_contrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Contrato(int id_contrato, String descripcion, Cliente cliente, Servicio servicio) {
        this.id_contrato = id_contrato;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.servicio = servicio;


    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id_contrato=" + id_contrato +
                ", descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                ", servicio=" + servicio +
                '}';
    }
}

