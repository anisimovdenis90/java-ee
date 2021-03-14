package com.anisimovdenis;

import com.anisimovdenis.service.ProductDto;

import java.util.List;

public class CategoryDto {

    private Long id;

    private String name;

    private List<ProductDto> productList;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String name, List<ProductDto> productDtoList) {
        this.id = id;
        this.name = name;
        this.productList = productDtoList;
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

    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productDtoList) {
        this.productList = productDtoList;
    }
}
