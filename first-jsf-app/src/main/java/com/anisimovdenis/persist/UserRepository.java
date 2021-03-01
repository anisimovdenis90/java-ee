package com.anisimovdenis.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.time.LocalDate;
import java.util.List;

@Named
@ApplicationScoped
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @PostConstruct
    public void init() throws SystemException {
        if (countAll() == 0) {
            try {
                ut.begin();
                saveOrUpdate(new User(null, "Bob", "Johnson", "bob@mail.com", LocalDate.of(1990, 12, 5), "89994443322"));
                saveOrUpdate(new User(null, "Den", "Dickens", "den@mail.com", LocalDate.of(1980, 10, 13), "89994333120"));
                saveOrUpdate(new User(null, "Carl", "Willis", "carl@mail.com", LocalDate.of(1964, 3, 21), "899955777311"));
                ut.commit();
            } catch (Exception e) {
                logger.error("", e);
                ut.rollback();
            }
        }
    }

    public Long countAll() {
        return em.createNamedQuery("countAllUsers", Long.class).getSingleResult();
    }

    public List<User> findAll() {
        return em.createNamedQuery("findAllUsers", User.class).getResultList();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void saveOrUpdate(User user) {
        if (user.getId() == null) {
            em.persist(user);
        }
        em.merge(user);
    }

    @Transactional
    public void deleteById(Long id) {
        em.createNamedQuery("deleteUserById").setParameter("id", id).executeUpdate();
    }
}
