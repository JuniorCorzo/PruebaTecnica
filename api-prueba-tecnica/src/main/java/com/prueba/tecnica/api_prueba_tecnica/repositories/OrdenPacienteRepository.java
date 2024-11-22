package com.prueba.tecnica.api_prueba_tecnica.repositories;

import com.prueba.tecnica.api_prueba_tecnica.models.OrdenPaciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenPacienteRepository extends MongoRepository<OrdenPaciente, String> {
}
