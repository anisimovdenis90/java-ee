package com.anisimovdenis.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {

    Long countAll();

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void saveOrUpdate(ProductDto productDto);

    void deleteById(Long id);
}
