package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.persist.ProductRepository;
import com.anisimovdenis.rest.ProductServiceRest;
import com.anisimovdenis.util.DtoUtil;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
//@Remote(ProductServiceRemote.class)
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
        return productRepository.findAll().stream().map(DtoUtil::buildProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByName(String name) {
        return productRepository.findByName(name).stream().map(DtoUtil::buildProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(DtoUtil::buildProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            return DtoUtil.buildProductDto(product);
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
