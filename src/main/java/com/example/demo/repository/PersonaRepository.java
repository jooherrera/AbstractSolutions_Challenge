package com.example.demo.repository;

import com.example.demo.model.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class PersonaRepository {

    private final HashMap<Integer, Persona> listaDePersonas;

    public PersonaRepository() {
        this.listaDePersonas = new HashMap();
    }

    public void add(Persona persona)throws Exception{
        Persona existsPerson = this.listaDePersonas.get(persona.getDni());
            
        if(existsPerson != null) throw new Exception("Ya existe una persona con ese DNI");
        
        
        this.listaDePersonas.put(persona.getDni(), persona);
    }

    public Persona findOne(int dni) throws Exception {
        Persona personaBuscada = this.listaDePersonas.get(dni);
        if (personaBuscada == null) {
            throw new Exception("No existe la persona");
        }
        return personaBuscada;
    }

    public ArrayList<Persona> findByApellido(String palabra) {
        ArrayList<Persona> match = new ArrayList();

        this.listaDePersonas.forEach((dni, persona) -> {

            String apellido = persona.getApellido();
            boolean startsWith = apellido.startsWith(palabra);

            if (startsWith) {
                match.add(persona);
            }
        });

        return match;
    }

    public void updateSexo(int dni, String sexo) throws Exception {

        Persona persona = this.listaDePersonas.get(dni);

        if (persona == null) {
            throw new Exception("No existe la persona");
        }

        persona.cambiarSexo(sexo);

        this.listaDePersonas.replace(dni, persona);

    }

    @Override
    public String toString() {
        return "Lista de personas" + this.listaDePersonas;
    }

}
