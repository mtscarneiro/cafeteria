package mtscarneirodev.cafeteria.products.model.repositories;

import mtscarneirodev.cafeteria.products.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
