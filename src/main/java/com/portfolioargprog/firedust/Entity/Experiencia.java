package com.portfolioargprog.firedust.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String aniosE1;
    private String aniosE2;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String aniosE1, String aniosE2) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.aniosE1 = aniosE1;
        this.aniosE2 = aniosE2;
    }

    public String getAniosE2() {
        return aniosE2;
    }

    public void setAniosE2(String aniosE2) {
        this.aniosE2 = aniosE2;
    }

    public String getAniosE1() {
        return aniosE1;
    }

    public void setAniosE1(String aniosE1) {
        this.aniosE1 = aniosE1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}
