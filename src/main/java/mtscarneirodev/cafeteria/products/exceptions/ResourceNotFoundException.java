package mtscarneirodev.cafeteria.products.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("ID " + id + " does not exist in database!");
    }
}
