package mtscarneirodev.cafeteria.clients.controllers;

import mtscarneirodev.cafeteria.clients.model.entities.Client;
import mtscarneirodev.cafeteria.clients.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // localhost:8080/api/clients
    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        List<Client> clients = clientService.readAllClients();

        return ResponseEntity.ok().body(clients);
    }

    // localhost:8080/api/clients/2
    @GetMapping("/{id}")
    public ResponseEntity<Client> readByID(@PathVariable Long id) {
        Client client = clientService.readAClientByItsID(id);

        return ResponseEntity.ok().body(client);
    }

    // localhost:8080/api/clients/new
    @PostMapping("/new")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        client = clientService.registerNewClient(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(client);
    }
}
