package com.anisimovdenis.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {

    void addToCart(ProductDto productDto);

    void removeFromCart(ProductDto productDto);

    List<ProductDto> getCart();
}
