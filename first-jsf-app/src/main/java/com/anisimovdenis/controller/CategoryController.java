package com.anisimovdenis.controller;

import com.anisimovdenis.CategoryDto;
import com.anisimovdenis.service.CategoryService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryController implements Serializable {

    @EJB
    private CategoryService categoryService;

    private List<CategoryDto> categories;

    private CategoryDto categoryDto;

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        categories = categoryService.findAll();
    }

    public String createCategory() {
        this.categoryDto = new CategoryDto();
        return "/category_form.xhtml?faces-redirect=true";
    }

    public List<CategoryDto> getAllCategories() {
        return categories;
    }

    public String editCategory(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
        return "/category_form.xhtml?faces-redirect=true";
    }

    public void deleteCategory(CategoryDto categoryDto) {
        categoryService.deleteById(categoryDto.getId());
    }

    public String saveCategory() {
        categoryService.saveOrUpdate(categoryDto);
        return "/category.xhtml?faces-redirect=true";
    }
}
