package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import com.example.demo.utils.Response;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Object> add(@RequestBody Persona persona) {
        try {
            service.add(persona);
            return new ResponseEntity<>(response.success("Agregado correctamente"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/personas/{dni}")
    public ResponseEntity<Object> findOne(@PathVariable int dni) {
        try {
            return new ResponseEntity<>(service.findOne(dni), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/personas")
    public ResponseEntity<Object> findOne(@RequestParam String apellido) {
        try {
            return new ResponseEntity<>(service.findByApellido(apellido), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/personas/{dni}")
    public ResponseEntity<Object> updateSexo(@RequestBody Map<String, Object> requestBody, @PathVariable int dni) {
        try {
            String sexo = requestBody.get("sexo").toString();
            service.updateSexo(dni, sexo);
            return new ResponseEntity<>(response.success("Actualizado correctamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
