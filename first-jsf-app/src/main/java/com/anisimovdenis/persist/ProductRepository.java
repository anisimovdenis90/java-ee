package com.anisimovdenis.persist;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepository {

    @EJB
    private CategoryRepository categoryRepository;

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public Long countAll() {
        return em.createNamedQuery("countAllProducts", Long.class).getSingleResult();
    }

    public List<Product> findAll() {
        return em.createNamedQuery("findAllProducts", Product.class).getResultList();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return em.createNamedQuery("findProductsByCategoryId", Product.class).setParameter("categoryId", categoryId).getResultList();
    }

    public List<Product> findByName(String name) {
        return em.createNamedQuery("findProductsByName", Product.class).setParameter("name", name).getResultList();
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        }
        em.merge(product);
    }

    public void deleteById(Long id) {
        em.createNamedQuery("deleteProductById").setParameter("id", id).executeUpdate();
    }
}
