package com.anisimovdenis.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleRepository {

    private final Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    @TransactionAttribute
    public Role merge(Role role) {
        return em.merge(role);
    }

    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

    public long getCount() {
        return em.createQuery("select count(*) from Role", Long.class)
                .getSingleResult();
    }

    public Long countAll() {
        return em.createNamedQuery("countAllRoles", Long.class).getSingleResult();
    }

    public List<Role> findAll() {
        return em.createNamedQuery("findAllRoles", Role.class).getResultList();
    }

    public void deleteById(Long id) {
        em.createNamedQuery("deleteRoleById").setParameter("id", id).executeUpdate();
    }

    public void saveOrUpdate(Role role) {
        if (role.getId() == null) {
            em.persist(role);
        }
        em.merge(role);
    }
}
