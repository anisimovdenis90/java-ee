package com.anisimovdenis.service;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();

    void deleteById(Long id);

    void saveOrUpdate(RoleDto roleDto);
}
