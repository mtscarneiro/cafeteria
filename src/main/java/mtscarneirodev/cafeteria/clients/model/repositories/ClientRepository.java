package mtscarneirodev.cafeteria.clients.model.repositories;

import mtscarneirodev.cafeteria.clients.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
