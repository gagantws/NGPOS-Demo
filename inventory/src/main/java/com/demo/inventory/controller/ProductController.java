package com.demo.inventory.controller;
import com.demo.inventory.entities.Product;
import com.demo.inventory.entities.ProductOverview;
import com.demo.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private final InventoryService inventoryService;

//    @Autowired
//    Environment environment;


    public ProductController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = inventoryService.getAllProducts();
//        System.out.println(environment.getProperty("local.server.port"));
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable String id) {
        return inventoryService.getProductById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/overview")
    public ResponseEntity<List<ProductOverview>> getProductOverview(){

        List<ProductOverview> productOverview = inventoryService.getProductsOverview();
//        System.out.println(environment.getProperty("local.server.port"));
        return productOverview.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productOverview);
    }

}