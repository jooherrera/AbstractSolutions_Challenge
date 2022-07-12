package com.example.demo.model;

public class Persona {

    private String nombre;
    private String apellido;
    private String sexo;
    private Integer dni;

    public Persona(String nombre, String apellido, String sexo, Integer dni) throws Exception{       
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

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
}
