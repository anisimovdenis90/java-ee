package com.anisimovdenis.service;

import java.util.List;

public interface ProductServiceRemote {

    Long countAll();

    List<ProductDto> findAll();

    ProductDto findById(Long id);
}
