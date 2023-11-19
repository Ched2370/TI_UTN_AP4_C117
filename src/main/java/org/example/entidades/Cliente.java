package org.example.entidades;

import jakarta.persistence.*;

@Entity
public class Cliente {
    private int cuit;
    private String razonSocial;
    public Cliente(){

    }

    public Cliente(int cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cuit=" + cuit +
                ", razonSocial='" + razonSocial + '\'' +
                '}';
    }
}



