package com.demo.inventory.controller;
import com.demo.inventory.dto.DeductRequestDTO;
import com.demo.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/stock")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    @Autowired
    Environment environment;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        
    }

    @PostMapping("/deduct")
    public ResponseEntity<?> deductStock(@RequestBody DeductRequestDTO request) {
        try {
            inventoryService.deductItems(request);
            System.out.println(environment.getProperty("local.server.port"));
            return ResponseEntity.ok().body(Map.of("status", "DEDUCTION_COMMITTED"));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
        }
    }
}
