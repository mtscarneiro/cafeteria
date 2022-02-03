package mtscarneirodev.cafeteria.login;

import mtscarneirodev.cafeteria.clients.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    private ClientService clientService;

    public LoginService(ClientService clientService) {
        this.clientService = clientService;
    }

    public boolean isRegistered(String email, String password) {
        var emailRegistered = clientService.readAllClients();

        for (int i = 0; i <= emailRegistered.size(); i++) {
            if (Objects.equals(emailRegistered.get(i).getEmail(), email)) {
                if (Objects.equals(password, emailRegistered.get(i).getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

}
