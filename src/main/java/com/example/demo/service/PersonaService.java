package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repo;

    public void add(Persona persona) throws Exception {
        repo.add(persona);
    }

    public Persona findOne(int dni) throws Exception {
        return repo.findOne(dni);
    }

    public ArrayList<Persona> findByApellido(String palabra) throws Exception {
        if (palabra.length() < 3) {
            throw new Exception("Minimo 3 letras para buscar");
        }
        return repo.findByApellido(palabra);
    }

    public void updateSexo(int dni, String sexo) throws Exception {
        repo.updateSexo(dni, sexo);
    }

}
