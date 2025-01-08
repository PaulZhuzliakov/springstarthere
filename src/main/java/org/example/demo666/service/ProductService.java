package org.example.demo666.service;

import org.example.demo666.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(200.0);
        this.products.add(product);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public List<Product> findAll() {
        return products;
    }
}
