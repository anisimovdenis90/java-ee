package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public Long countAll() {
        return categoryRepository.countAll();
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        return new CategoryDto(categoryRepository.findById(id));
    }

    @Override
    @TransactionAttribute
    public void saveOrUpdate(CategoryDto categoryDto) {
        categoryRepository.saveOrUpdate(new Category(categoryDto));
    }

    @Override
    @TransactionAttribute
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
