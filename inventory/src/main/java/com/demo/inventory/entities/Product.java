package com.demo.inventory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ProductInfo")
public class Product {

    @Id
    private String product_id;
    private String sku;
    private String name;
    private String description;
    private int price;
    private String currency;
    private int quantity;



}
