package org.example.entidades;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incidente")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private int id_incidente;

    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "fecha_finalizado")
    private Date fecha_finalizado;
    @Column(name = "resuelto")
    private boolean resuelto;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    private Operador operador;

    @ManyToOne
    @JoinColumn(name = "id_problema")
    private Problema problema;

    public Incidente() {
    }

    public Incidente(String descripcion, Date fecha_inicio, Date fecha_finalizado, boolean resuelto, Tecnico tecnico, Especialidad especialidad, Operador operador, Problema problema) {
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizado = fecha_finalizado;
        this.resuelto = resuelto;
        this.tecnico = tecnico;
        this.especialidad = especialidad;
        this.operador = operador;
        this.problema = problema;

    }

    public Incidente(int id_incidente, String descripcion, Date fecha_inicio, Date fecha_finalizado, boolean resuelto, Tecnico tecnico, Especialidad especialidad, Operador operador, Problema problema) {
        this.id_incidente = id_incidente;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizado = fecha_finalizado;
        this.resuelto = resuelto;
        this.tecnico = tecnico;
        this.especialidad = especialidad;
        this.operador = operador;
        this.problema = problema;
    }

    public int getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_finalizado() {
        return fecha_finalizado;
    }

    public void setFecha_finalizado(Date fecha_finalizado) {
        this.fecha_finalizado = fecha_finalizado;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public void setResuelto(boolean resuelto) {
        this.resuelto = resuelto;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

}
