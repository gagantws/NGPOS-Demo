package com.demo.inventory.service;

import com.demo.inventory.entities.Product;
import com.demo.inventory.repository.ProductRepository;
import com.demo.inventory.dto.DeductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private final ProductRepository repo;


    public InventoryService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product createProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> getAllProducts() {
        System.out.println(repo.findAll());
        return repo.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repo.findById(id);
    }


    @Transactional // Ensures all stock updates succeed or fail together
    public void deductItems(DeductRequestDTO request) {
        for (Map<String, Object> item : request.getItems()) {
            String productId = (String) item.get("product_id");
            Integer quantityToDeduct = (Integer) item.get("quantity");

            Product p = repo.findById(productId)
                    .orElseThrow(() -> new RuntimeException("INSUFFICIENT_STOCK: Product not found: " + productId));

            if (p.getQuantity() < quantityToDeduct) {
                throw new RuntimeException("INSUFFICIENT_STOCK: Not enough stock for " + p.getSku());
            }

            p.setQuantity(p.getQuantity() - quantityToDeduct);
            repo.save(p);
        }
    }

}
