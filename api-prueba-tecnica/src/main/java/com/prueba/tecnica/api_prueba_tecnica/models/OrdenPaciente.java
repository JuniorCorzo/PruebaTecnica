package com.prueba.tecnica.api_prueba_tecnica.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("ordenPaciente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdenPaciente {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String nombre;
    private String apellido;
    private String codigoOrden;
    private List<Examenes> examenes;
}
