package com.demo.inventory.Controller;

import com.demo.inventory.Entities.Product;
import com.demo.inventory.Repository.ProductRepository;
import com.demo.inventory.DTO.ReserveRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final ProductRepository repo;

    public InventoryController(ProductRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product p) {
        return repo.save(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable String id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping("/reserve")
//    public ResponseEntity<?> reserve(@RequestBody ReserveRequest request) {
//        // For each product, check quantity and decrement if possible
//        for (Map.Entry<String,Integer> e : request.getItems().entrySet()) {
//            String productId = e.getKey();
//            int qty = e.getValue();
//            Optional<Product> op = repo.findById(productId);
//            if (!op.isPresent()) {
//                return ResponseEntity.badRequest().body("Product " + productId + " not found");
//            }
//            Product p = op.get();
//            if (p.getQuantity() < qty) {
//                return ResponseEntity.badRequest().body("Insufficient quantity for product " + productId);
//            }
//        }
//        // all good — perform updates
//        for (Map.Entry<String,Integer> e : request.getItems().entrySet()) {
//            String productId = e.getKey();
//            int qty = e.getValue();
//            Product p = repo.findById(productId).get();
//            p.setQuantity(p.getQuantity() - qty);
//            repo.save(p);
//        }
//        return ResponseEntity.ok("Reserved");
//    }
}
