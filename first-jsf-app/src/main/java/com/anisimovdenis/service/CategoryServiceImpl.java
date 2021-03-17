package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.rest.CategoryServiceRest;
import com.anisimovdenis.util.DtoUtil;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(CategoryServiceRemote.class)
public class CategoryServiceImpl implements CategoryService, CategoryServiceRemote, CategoryServiceRest {

    @EJB
    private ProductService productService;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public Long countAll() {
        return categoryRepository.countAll();
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(DtoUtil::buildCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findAllWithProducts() {
        return categoryRepository.findAllWithProducts().stream().map(DtoUtil::buildCategoryDtoWithProducts).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        return DtoUtil.buildCategoryDto(categoryRepository.findById(id));
    }

    @Override
    public void insert(CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(categoryDto);
    }

    @Override
    public void update(CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(categoryDto);
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
