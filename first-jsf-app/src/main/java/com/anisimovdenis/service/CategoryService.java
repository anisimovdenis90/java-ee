package com.anisimovdenis.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryService {

    Long countAll();

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    void saveOrUpdate(CategoryDto category);

    void deleteById(Long id);
}
