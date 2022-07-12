package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class PersonaController {

    @Autowired
    PersonaService service;
    
    @Autowired
    Response response;
        
    @PostMapping("/personas")
    public ResponseEntity<Object> add(@RequestBody Persona persona ) {
        try {
            service.add(persona);
            return new ResponseEntity<>(response.success("Agregado correctamente"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/personas")
    public ResponseEntity<Object> findOne(@RequestParam int dni){
        try {            
            return new ResponseEntity<>(service.findOne(dni),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
