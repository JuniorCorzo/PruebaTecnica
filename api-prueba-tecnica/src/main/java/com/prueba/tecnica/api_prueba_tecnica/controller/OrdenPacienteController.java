package com.prueba.tecnica.api_prueba_tecnica.controller;

import com.prueba.tecnica.api_prueba_tecnica.models.OrdenPaciente;
import com.prueba.tecnica.api_prueba_tecnica.service.OrdenPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden-paciente")
public class OrdenPacienteController {
    private final OrdenPacienteService ordenPacienteService;

    @Autowired
    public OrdenPacienteController(OrdenPacienteService ordenPacienteService) {
        this.ordenPacienteService = ordenPacienteService;
    }

    @GetMapping("/")
    public List<OrdenPaciente> getAllOrdens(){
        return this.ordenPacienteService.getAllOrdens();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/insert")
    public void insertOrden(@RequestBody OrdenPaciente insertOrden) {
        this.ordenPacienteService.insertOrden(insertOrden);
    }
}

