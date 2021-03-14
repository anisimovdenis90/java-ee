package com.anisimovdenis.persist;

import com.anisimovdenis.CategoryDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "findAllCategories", query = "FROM Category"),
        @NamedQuery(name = "countAllCategories", query = "SELECT COUNT(*) FROM Category"),
        @NamedQuery(name = "findAllCategoriesWithProducts", query = "SELECT c FROM Category c JOIN FETCH c.products"),
        @NamedQuery(name = "deleteCategoryById", query = "DELETE FROM Category c WHERE c.id = :id")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 3, message = "Minimum 3 symbols")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(CategoryDto categoryDto) {
        this(categoryDto.getId(), categoryDto.getName());
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
