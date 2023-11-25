package org.example.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private int id_tecnico;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "especialidad_tecnico",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
    )
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Tecnico() {
    }

    public Tecnico(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "id_tecnico=" + id_tecnico + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

}
