package com.GrupoN.prototipo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private Integer edad;
    private Float peso;
    private Integer nivelStress;
    private String horarioSueno;

    public Usuario() {
    }

    public Usuario(String nombre, Integer edad, Float peso, Integer nivelStress, String horarioSueno) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.nivelStress = nivelStress;
        this.horarioSueno = horarioSueno;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getNivelStress() {
        return nivelStress;
    }

    public void setNivelStress(Integer nivelStress) {
        this.nivelStress = nivelStress;
    }

    public String getHorarioSueno() {
        return horarioSueno;
    }

    public void setHorarioSueno(String horarioSueno) {
        this.horarioSueno = horarioSueno;
    }
}
