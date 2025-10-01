package com.demo.inventory.Repository;

import com.demo.inventory.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> { }
