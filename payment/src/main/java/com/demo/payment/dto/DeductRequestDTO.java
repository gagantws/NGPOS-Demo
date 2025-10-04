package com.demo.payment.dto;

import java.util.List;
import java.util.Map;

public class DeductRequestDTO {

    private List<Map<String, Object>> items;

    // Getters and Setters
    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }
}