package com.dgtfactory.dgtfactoryassignment.client;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@OpenAPIDefinition(tags = {@Tag(name = "Client", description = "Endpoints for client resources")})
public class ClientController {

    private final ClientService service;

    private final ModelMapper modelMapper;

    public ClientController(
            ClientService service,
            ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/clients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieve list of all clients",
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientDTO.class))))
    })
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<ClientDTO> clients = this.service.getAll()
                .stream()
                .map(client ->
                        modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());

        if (clients.size() > 0) {
            return ResponseEntity
                    .ok()
                    .body(clients);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO create(@Valid @RequestBody ClientDTO client) {
        Client newClient = this.service.save(
                this.modelMapper.map(client, Client.class)
        );

        return this.modelMapper.map(newClient, ClientDTO.class);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        ClientDTO client = this.modelMapper.map(this.service.getById(id), ClientDTO.class);

        if (client != null) {
            return ResponseEntity
                    .ok()
                    .body(client);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/clients/{id}")
    public ClientDTO update(@Valid @RequestBody ClientDTO client, @PathVariable Long id) {
        Client updatedClient = this.service.update(this.modelMapper.map(client, Client.class), id);

        return this.modelMapper.map(updatedClient, ClientDTO.class);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
