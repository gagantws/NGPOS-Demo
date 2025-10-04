package com.demo.payment.client;

import com.demo.payment.dto.DeductRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {

    // This method signature must match the one in InventoryController
    @PostMapping("/api/v1/stock/deduct")
    ResponseEntity<Map<String, String>> deductStock(@RequestBody DeductRequestDTO request);
}