package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.entities.Product;
import com.domain.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    // Fixed path for getting a product by id
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    // Updated PutMapping to include ID for updates
    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        // Ensure the ID in the path matches the ID of the product being updated
        product.setId(id);
        return productService.save(product);
    }

    // DELETE method to handle product deletion
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
