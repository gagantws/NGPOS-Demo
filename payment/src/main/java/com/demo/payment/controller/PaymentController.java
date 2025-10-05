package com.demo.payment.controller;

import com.demo.payment.dto.PaymentRequestDTO;
import com.demo.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    Environment environment;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequestDTO request) {
        try {
            // Delegate to the service layer
            var result = paymentService.processPurchase(request);
            System.out.println(environment.getProperty("local.server.port"));
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (RuntimeException ex) {

            // If stock deduction fails, this exception will be caught
            return ResponseEntity.badRequest().body(Map.of("error", "TRANSACTION_FAILED", "reason", ex.getMessage()));
        }
    }
}