package com.demo.inventory.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;

    // constructors, getters/setters
//    public Product() {}
//    public Product(String id, String name, int quantity) {
//        this.id = id; this.name = name; this.quantity = quantity;
//    }

}
