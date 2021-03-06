package com.anisimovdenis.persist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public Long countAll() {
        return em.createNamedQuery("countAllCategories", Long.class).getSingleResult();
    }

    public List<Category> findAll() {
        return em.createNamedQuery("findAllCategories", Category.class).getResultList();
    }

    public List<Category> findAllWithProducts() {
        return em.createNamedQuery("findAllCategoriesWithProducts", Category.class).getResultList();
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public Category getReference(Long id) {
        return em.getReference(Category.class, id);
    }

    public void saveOrUpdate(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        }
        em.merge(category);
    }

    public void deleteById(Long id) {
        em.createNamedQuery("deleteCategoryById").setParameter("id", id).executeUpdate();
    }
}
