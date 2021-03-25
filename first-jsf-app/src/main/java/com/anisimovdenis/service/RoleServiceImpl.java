package com.anisimovdenis.service;

import com.anisimovdenis.persist.Role;
import com.anisimovdenis.persist.RoleRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleRepository roleRepository;

    @TransactionAttribute
    public List<RoleDto> getAllRoles() {
        return roleRepository.getAllRoles().stream()
                .map(RoleDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @TransactionAttribute
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(RoleDto roleDto) {
        roleRepository.saveOrUpdate(new Role(roleDto));
    }
}
