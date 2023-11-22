package org.example.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema")
    private int id_problema;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "cuit")
    private Cliente cliente;

    @OneToMany(mappedBy = "problema", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Problema() {
    }

    public Problema(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public Problema(int id_problema, String descripcion, Cliente cliente) {
        this.id_problema = id_problema;
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public int getId_problema() {
        return id_problema;
    }

    public void setId_problema(int id_problema) {
        this.id_problema = id_problema;
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

}
