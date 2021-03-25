package com.anisimovdenis.service;

import java.util.List;

public interface CategoryServiceRemote {

    Long countAll();

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);
}
