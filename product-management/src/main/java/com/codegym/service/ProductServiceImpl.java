package com.codegym.service;

import com.codegym.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "iPhone 15", 999.0, "Apple flagship smartphone", "Apple"));
        products.put(2, new Product(2, "Samsung Galaxy S24", 899.0, "AI smartphone", "Samsung"));
        products.put(3, new Product(3, "Sony WH-1000XM5", 399.0, "Noise cancelling headphones", "Sony"));
        products.put(4, new Product(4, "MacBook Air M3", 1099.0, "Lightweight laptop", "Apple"));
        products.put(5, new Product(5, "Dell XPS 13", 1199.0, "Ultrabook premium", "Dell"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        if (name == null || name.trim().isEmpty()) {
            return findAll();
        }
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}