package org.example.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "operador")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operador")
    private int id_operador;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Operador() {
    }

    public Operador(String nombre) {
        this.nombre = nombre;
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

}
