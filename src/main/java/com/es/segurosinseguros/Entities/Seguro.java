package com.es.segurosinseguros.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "seguro")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;

    @Column(name = "nif", nullable = false, unique = true)
    private String nif;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fechaInicio", nullable = false)
    private String fechaInicio;

    @Column(name = "ape1", nullable = false)
    private String ape1;

    @Column(name = "ape2", nullable = false)
    private String ape2;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "numHijos", nullable = false)
    private int numHijos;

    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "casado", nullable = false)
    private boolean casado;

    @Column(name = "embarazada", nullable = false)
    private boolean embarazada;

    public Seguro(Long idSeguro, String nif, String nombre, String fechaInicio, String ape1, String ape2,int edad, int numHijos, Date fechaCreacion, String sexo, boolean casado, boolean embarazada) {
        this.idSeguro = idSeguro;
        this.nif = nif;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
        this.sexo = sexo;
        this.casado = casado;
        this.embarazada = embarazada;
        this.edad = edad;
    }
    public Seguro(){

    }

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
