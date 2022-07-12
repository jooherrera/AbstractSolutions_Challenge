package com.example.demo.model;

import lombok.Getter;

@Getter
public class Persona {

    private String nombre;
    private String apellido;
    private String sexo;
    private int dni;

    public Persona(String nombre, String apellido, String sexo, int dni) throws Exception {
        if (nombre.equals("") || apellido.equals("") || sexo.equals("")) {
            throw new Exception("Parámetros inválidos");
        }

        if (dni <= 0 || dni >= 99999999) {
            throw new Exception("Formato de DNI incorrecto");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
    }

    public void cambiarSexo(String sexo) throws Exception {
        if (sexo.equals("")) {
            throw new Exception("Parámetro inválido");
        }
        this.sexo = sexo;
    }

}
