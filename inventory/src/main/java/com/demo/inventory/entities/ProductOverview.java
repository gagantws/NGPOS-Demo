package com.demo.inventory.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ProductInfo")
public class ProductOverview {

    @Id
    private String product_id;
    private String sku;
    private String name;
    private int price;

}
