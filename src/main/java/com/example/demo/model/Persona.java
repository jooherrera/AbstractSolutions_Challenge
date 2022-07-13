package com.example.demo.model;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class Persona {

    private String nombre;
    private String apellido;
    private String sexo;
    private LocalDate fechaNacimiento;
    private int dni;

    public Persona(String nombre, String apellido, String sexo, String fechaNacimiento, int dni) throws Exception {
        if (nombre.equals("") || apellido.equals("") || sexo.equals("") || fechaNacimiento.equals("")) {
            throw new Exception("Parámetros inválidos");
        }

        if (dni <= 0 || dni > 99999999) {
            throw new Exception("Formato de DNI incorrecto");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fdn = LocalDate.parse(fechaNacimiento, formatter);

        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.fechaNacimiento = fdn;

    }

    public void cambiarSexo(String sexo) throws Exception {
        if (sexo.equals("")) {
            throw new Exception("Parámetro inválido");
        }
        this.sexo = sexo;
    }

}
