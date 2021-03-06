package com.anisimovdenis.controller;

import com.anisimovdenis.service.ProductDto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@SessionScoped
public class CartController implements Serializable {

    private Map<Long, ProductDto> productMap = new HashMap<>();

    public void addToCart(ProductDto product) {
        productMap.put(product.getId(), product);
    }

    public void removeFromCart(ProductDto product) {
        productMap.remove(product.getId());
    }

    public List<ProductDto> getCart() {
        return new ArrayList<>(productMap.values());
    }
}
