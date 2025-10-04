package com.demo.payment.service;

import com.demo.payment.client.InventoryServiceClient;
import com.demo.payment.dto.DeductRequestDTO;
import com.demo.payment.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentService {

    private final InventoryServiceClient inventoryServiceClient;

    public PaymentService(InventoryServiceClient inventoryServiceClient) {
        this.inventoryServiceClient = inventoryServiceClient;
    }

    public Map<String, String> processPurchase(PaymentRequestDTO request) {
        // Prepare the request DTO for the Inventory Service
        DeductRequestDTO deductRequest = new DeductRequestDTO();
        deductRequest.setItems(request.getItems());

        // Call the Inventory Service using the Feign client
        try {
            inventoryServiceClient.deductStock(deductRequest);
        } catch (Exception e) {
            // Feign will throw an exception for non-2xx responses
            throw new RuntimeException("INSUFFICIENT_STOCK");
        }

        // If the call was successful, proceed with payment
        System.out.println("Payment captured successfully for card token: " + request.getCardDetails().get("token"));

        return Map.of("status", "COMPLETED", "transactionId", "txn_" + System.currentTimeMillis());
    }
}