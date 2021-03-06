package com.anisimovdenis.service;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.persist.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceImpl implements ProductService, ProductServiceRemote {

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
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            return new ProductDto(product);
        }
       return null;
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
