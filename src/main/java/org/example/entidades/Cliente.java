package org.example.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "cuit")
    private int cuit;

    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "activo")
    private boolean activo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Contrato> contratos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Problema> problemas;

    public Cliente() {
    }

    public Cliente(int cuit, String razonSocial, boolean activo) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.activo = activo;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cuit=" + cuit + ", razonSocial=" + razonSocial + '}';
    }

}
