package com.anisimovdenis.service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProductServiceRemote {

    Long countAll();

    List<ProductDto> findAll();

    ProductDto findById(Long id);
}
