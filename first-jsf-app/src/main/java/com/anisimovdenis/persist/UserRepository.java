package com.anisimovdenis.persist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public Long countAll() {
        return em.createNamedQuery("countAllUsers", Long.class).getSingleResult();
    }

    public List<User> findAll() {
        return em.createNamedQuery("findAllUsers", User.class).getResultList();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void saveOrUpdate(User user) {
        if (user.getId() == null) {
            em.persist(user);
        }
        em.merge(user);
    }

    public void deleteById(Long id) {
        em.createNamedQuery("deleteUserById").setParameter("id", id).executeUpdate();
    }
}
