package org.example.demo666.controller;

import org.example.demo666.model.Product;
import org.example.demo666.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model) {
        System.out.println("POST");
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productService.addProduct(product);

        List<Product> products = productService.findAll();

        model.addAttribute("products", products);
        return "products.html";
    }
}
