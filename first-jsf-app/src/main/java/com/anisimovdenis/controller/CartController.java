package com.anisimovdenis.controller;

import com.anisimovdenis.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {

    private Map<Long, Product> productMap = new HashMap<>();

    public String addToCart(Product product) {
        productMap.put(product.getId(), product);
        return "";
    }

    public String removeFromCart(Product product) {
        productMap.remove(product.getId());
        return "";
    }

    public Collection<Product> getCart() {
        return productMap.values();
    }
}
