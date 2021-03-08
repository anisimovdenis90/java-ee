package com.anisimovdenis.controller;

import com.anisimovdenis.service.CartService;
import com.anisimovdenis.service.ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public void addToCart(ProductDto productDto) {
        cartService.addToCart(productDto);
    }

    public void removeFromCart(ProductDto productDto) {
        cartService.removeFromCart(productDto);
    }

    public List<ProductDto> getCart() {
        return cartService.getCart();
    }
}
