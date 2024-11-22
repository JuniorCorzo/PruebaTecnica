package io.github.juniorcorzo.service;

import io.github.juniorcorzo.dto.ExamenesDto;
import io.github.juniorcorzo.dto.OrdenPacienteRequest;
import io.github.juniorcorzo.parser.Hl7Parser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendService {
    public void sendRequest(String HL7Message) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(this.prepareRequest(HL7Message));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/orden-paciente/insert"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Codigo de estado" + response.statusCode());
    }

    private OrdenPacienteRequest prepareRequest(String HL7Message) {
        Map<String, String> parsered = Hl7Parser.parserHl7Message(HL7Message);
        List<ExamenesDto> examenesList = new ArrayList<>();
        String[] nombre = parsered.get("PID").split("\\|")[5].split("\\^");

        for (String odx: parsered.get("OBX").split("~")){
            String[] splitOdx = odx.split("\\|");
            ExamenesDto examen = new ExamenesDto(
                    splitOdx[3].split("\\^")[0],
                    Float.parseFloat(splitOdx[5].split("\\^")[0])
            );
            examenesList.add(examen);
        }

        return new OrdenPacienteRequest(
                nombre[0],
                nombre[1],
                parsered.get("OBR").split("\\|")[2],
                examenesList
        );
    }
}
