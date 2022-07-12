package com.example.demo.model;

import lombok.ToString;


@ToString()
public class Persona {

    private String nombre;
    private String apellido;
    private String sexo;
    private int dni;

    public Persona(String nombre, String apellido, String sexo, int dni) throws Exception{       
        if(nombre.equals("") || apellido.equals("") || sexo.equals("")) {
            throw new Exception("Parámetros invalidos");
        }
        
        if(dni <= 0 || dni >= 99999999){
            throw new Exception("Dni inválido");
        }
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
    }
    
    public void cambiarSexo(String sexo) throws Exception{
        if(sexo.equals("")) throw new Exception("Parámetro inválido");
        this.sexo = sexo;
    }
    
    public int getDni(){
        return this.dni;
    }
    
    public String getApellido(){
        return this.apellido;
    }


}
