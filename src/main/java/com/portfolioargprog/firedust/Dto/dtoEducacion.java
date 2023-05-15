package com.portfolioargprog.firedust.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String aniosE1;
    @NotBlank
    private String aniosE2;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String aniosE1, String aniosE2) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.aniosE1 = aniosE1;
        this.aniosE2 = aniosE2;
    }

    public String getAniosE1() {
        return aniosE1;
    }

    public void setAniosE1(String aniosE1) {
        this.aniosE1 = aniosE1;
    }

    public String getAniosE2() {
        return aniosE2;
    }

    public void setAniosE2(String aniosE2) {
        this.aniosE2 = aniosE2;
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
