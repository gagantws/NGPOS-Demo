package com.demo.payment.dto;

import java.util.List;
import java.util.Map;

public class PaymentRequestDTO {
    private Map<String, String> cardDetails;
    private List<Map<String, Object>> items;


    public Map<String, String> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(Map<String, String> cardDetails) {
        this.cardDetails = cardDetails;
    }

    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }
}
