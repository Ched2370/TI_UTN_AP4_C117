package org.example.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private int id_contrato;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "cuit")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Contrato() {
    }

    public Contrato(String descripcion, Cliente cliente, Servicio servicio) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Contrato(int id_contrato, String descripcion, Cliente cliente, Servicio servicio) {
        this.id_contrato = id_contrato;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}
