package io.github.juniorcorzo.dto;

import java.util.List;

public record OrdenPacienteRequest(
        String nombre,
        String apellido,
        String codigoOrden,
        List<ExamenesDto> examenes
) {
}
