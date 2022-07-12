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

    public void add(Persona persona) throws Exception{
        repo.add(persona);
    }

    public Persona findOne(int dni) {
        try {
            return repo.findOne(dni);
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Persona> findByApellido(String palabra){
        return repo.findByApellido(palabra);
    }
    
    public void updateSexo(int dni, String sexo) throws Exception{
        try {
            repo.updateSexo(dni, sexo);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
