package com.anisimovdenis.controller;

import com.anisimovdenis.persist.Category;
import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.service.ProductDto;
import com.anisimovdenis.service.ProductService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductService productService;

    @EJB
    private CategoryRepository categoryRepository;

    private List<ProductDto> products;

    private List<Category> categories;

    private ProductDto product;

    public List<ProductDto> getAllProducts() {
        return products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        products = productService.findAll();
        categories = categoryRepository.findAll();
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new ProductDto();
        return "/product_form.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public String editProduct(ProductDto product) {
        this.product = product;
        return "/product_form.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDto product) {
        productService.deleteById(product.getId());
    }

    public String saveProduct() {
        productService.saveOrUpdate(product);
        return "/product.xhtml?faces-redirect=true";
    }
}
