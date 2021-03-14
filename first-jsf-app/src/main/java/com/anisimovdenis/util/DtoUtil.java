package com.anisimovdenis.util;

import com.anisimovdenis.CategoryDto;
import com.anisimovdenis.UserDto;
import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.persist.User;
import com.anisimovdenis.service.ProductDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DtoUtil {

    public static ProductDto buildProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        Category category = product.getCategory();
        productDto.setCategoryId(category != null ? category.getId() : null);
        productDto.setCategoryName(category != null ? category.getName() : null);

        return productDto;
    }

    public static CategoryDto buildCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProductList(Collections.emptyList());

        return categoryDto;
    }

    public static CategoryDto buildCategoryDtoWithProducts(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        List<ProductDto> productDtoList;
        List<Product> productList = category.getProducts();
        if (!productList.isEmpty()) {
            productDtoList = productList.stream().map(DtoUtil::buildProductDto).collect(Collectors.toList());
        } else {
            productDtoList = Collections.emptyList();
        }

        categoryDto.setProductList(productDtoList);

        return categoryDto;
    }

    public static UserDto buildUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
        userDto.setPhone(user.getPhone());

        return userDto;
    }
}
