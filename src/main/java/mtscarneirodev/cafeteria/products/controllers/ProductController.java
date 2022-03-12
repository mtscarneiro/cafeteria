package mtscarneirodev.cafeteria.products.controllers;

import mtscarneirodev.cafeteria.products.model.entities.Product;
import mtscarneirodev.cafeteria.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService clientService) {
        this.productService = clientService;
    }

    // localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        List<Product> products = productService.readAllProducts();

        return ResponseEntity.ok().body(products);
    }

    // localhost:8080/api/products/{UUID}
    @GetMapping("/{id}")
    public ResponseEntity<Product> readByID(@PathVariable Long id) {
        Product product = productService.readAProductByItsID(id);

        return ResponseEntity.ok().body(product);
    }

    // localhost:8080/api/products/new
    @PostMapping("/new")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        product = productService.registerNewProduct(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(product);
    }
}
