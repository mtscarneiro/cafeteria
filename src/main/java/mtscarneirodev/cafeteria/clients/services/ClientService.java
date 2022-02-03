package mtscarneirodev.cafeteria.clients.services;

import mtscarneirodev.cafeteria.clients.model.entities.Client;
import mtscarneirodev.cafeteria.clients.model.repositories.ClientRepository;
import mtscarneirodev.cafeteria.clients.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> readAllClients() {
        return clientRepository.findAll();
    }

    public Client readAClientByItsID(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return client.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client registerNewClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateClientData(Client oldClient, Client newClient) {
        oldClient.setName(newClient.getName());
        oldClient.setEmail(newClient.getEmail());
        oldClient.setPassword(newClient.getPassword());
    }

    public Client updateClient(Long id, Client newClient) {
        Client oldClient = clientRepository.getById(id);
        updateClientData(oldClient, newClient);

        return clientRepository.save(oldClient);
    }
}
