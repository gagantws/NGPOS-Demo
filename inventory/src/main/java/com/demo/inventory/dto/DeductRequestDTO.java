package com.demo.inventory.dto;
import java.util.List;
import java.util.Map;


public class DeductRequestDTO {

    private List<Map<String, Object>> items; // A list of items to deduct

    // Getters and Setters
    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }
}
