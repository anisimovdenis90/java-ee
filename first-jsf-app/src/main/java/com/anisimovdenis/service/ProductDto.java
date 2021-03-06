package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private String categoryName;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        Category category = product.getCategory();
        categoryId = category != null ? category.getId() : null;
        categoryName= category != null ? category.getName() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
