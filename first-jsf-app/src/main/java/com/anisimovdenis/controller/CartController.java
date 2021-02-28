package com.anisimovdenis.controller;

import com.anisimovdenis.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {

    private Map<Long, Product> productMap = new HashMap<>();

    public void addToCart(Product product) {
        productMap.put(product.getId(), product);
    }

    public void removeFromCart(Product product) {
        productMap.remove(product.getId());
    }

    public Collection<Product> getCart() {
        return new ArrayDeque<>(productMap.values());
    }
}
