package mtscarneirodev.cafeteria.products.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(UUID id) {
        super("ID " + id + " does not exist in database!");
    }
}
