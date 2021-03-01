package com.anisimovdenis.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@Named
@ApplicationScoped
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(Category.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @PostConstruct
    public void init() throws Exception {
        if (countAll() == 0) {
            try {
                ut.begin();
                saveOrUpdate(new Category(null, "Category 1"));
                saveOrUpdate(new Category(null, "Category 2"));
                ut.commit();
            } catch (Exception e) {
                logger.error("", e);
                ut.rollback();
            }
        }
    }

    public Long countAll() {
        return em.createNamedQuery("countAllCategories", Long.class).getSingleResult();
    }

    public List<Category> findAll() {
        return em.createNamedQuery("findAllCategories", Category.class).getResultList();
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    @Transactional
    public void saveOrUpdate(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        }
        em.merge(category);
    }

    @Transactional
    public void deleteById(Long id) {
        em.createNamedQuery("deleteCategoryById").setParameter("id", id).executeUpdate();
    }
}
