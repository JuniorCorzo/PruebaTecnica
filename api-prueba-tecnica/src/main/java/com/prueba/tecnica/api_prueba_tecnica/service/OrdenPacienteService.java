package com.prueba.tecnica.api_prueba_tecnica.service;

import com.prueba.tecnica.api_prueba_tecnica.models.OrdenPaciente;
import com.prueba.tecnica.api_prueba_tecnica.repositories.OrdenPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenPacienteService {
    private final OrdenPacienteRepository ordenPacienteRepository;

    @Autowired
    public OrdenPacienteService(OrdenPacienteRepository ordenPacienteRepository) {
        this.ordenPacienteRepository = ordenPacienteRepository;
    }

    public List<OrdenPaciente> getAllOrdens(){
        return this.ordenPacienteRepository.findAll();
    }

    public void insertOrden(OrdenPaciente orden){
        this.ordenPacienteRepository.insert(orden);
    }

}
