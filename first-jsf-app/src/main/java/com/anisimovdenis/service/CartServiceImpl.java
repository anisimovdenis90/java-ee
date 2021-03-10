package com.anisimovdenis.service;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateful
public class CartServiceImpl implements CartService {

    private final Map<Long, ProductDto> productMap = new HashMap<>();

    @Override
    public void addToCart(ProductDto productDto) {
        productMap.put(productDto.getId(), productDto);
    }

    @Override
    public void removeFromCart(ProductDto productDto) {
        productMap.remove(productDto.getId());
    }

    @Override
    public List<ProductDto> getCart() {
        return new ArrayList<>(productMap.values());
    }
}
