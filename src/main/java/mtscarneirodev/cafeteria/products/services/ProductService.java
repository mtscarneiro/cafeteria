package mtscarneirodev.cafeteria.products.services;

import mtscarneirodev.cafeteria.products.exceptions.ResourceNotFoundException;
import mtscarneirodev.cafeteria.products.model.entities.Product;
import mtscarneirodev.cafeteria.products.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAllProducts() {
        return productRepository.findAll();
    }

    public Product readAProductByItsID(UUID id) {
        Optional<Product> product = productRepository.findById(id);

        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product registerNewProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(UUID id) {
        try {
            productRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateProductData(Product oldProduct, Product newProduct) {
        oldProduct.setName(newProduct.getName());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setPrice(newProduct.getPrice());
    }

    public Product updateProduct(UUID id, Product newProduct) {
        Product oldProduct = productRepository.getById(id);
        updateProductData(oldProduct, newProduct);

        return productRepository.save(oldProduct);
    }
}
