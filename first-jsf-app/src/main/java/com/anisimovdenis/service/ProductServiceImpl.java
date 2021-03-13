package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.persist.ProductRepository;
import com.anisimovdenis.rest.ProductServiceRest;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(ProductServiceRemote.class)
public class ProductServiceImpl implements ProductService, ProductServiceRemote, ProductServiceRest {

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public Long countAll() {
        return productRepository.countAll();
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(this::buildProductDto).collect(Collectors.toList());
    }

    private ProductDto buildProductDto(Product product) {
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

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            return buildProductDto(product);
        }
        return null;
    }

    @Override
    public void insert(ProductDto productDto) {
        if (productDto.getId() != null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(productDto);
    }

    @Override
    public void update(ProductDto productDto) {
        if (productDto.getId() == null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(productDto);
    }

    @TransactionAttribute
    @Override
    public void saveOrUpdate(ProductDto productDto) {
        Category category = null;
        if (productDto.getCategoryId() != null) {
            category = categoryRepository.getReference(productDto.getCategoryId());
        }
        productRepository.saveOrUpdate(new Product(productDto, category));
    }

    @TransactionAttribute
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
