package mtscarneirodev.cafeteria.products.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("ID " + id + " does not exist in database!");
    }
}
