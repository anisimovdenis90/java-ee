package com.anisimovdenis.controller;

import com.anisimovdenis.service.RoleDto;
import com.anisimovdenis.service.RoleService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RoleController implements Serializable {

    @EJB
    private RoleService roleService;

    private List<RoleDto> roles;

    private RoleDto roleDto;

    public RoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDto roleDto) {
        this.roleDto = roleDto;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        roles = roleService.getAllRoles();
    }

    public String createRole() {
        this.roleDto = new RoleDto();
        return "/admin/role_form.xhtml?faces-redirect=true";
    }

    public List<RoleDto> getAllRoles() {
        return roles;
    }

    public String editRole(RoleDto roleDto) {
        this.roleDto = roleDto;
        return "/admin/role_form.xhtml?faces-redirect=true";
    }

    public void deleteRole(RoleDto roleDto) {
        roleService.deleteById(roleDto.getId());
    }

    public String saveRole() {
        roleService.saveOrUpdate(roleDto);
        return "/admin/role.xhtml?faces-redirect=true";
    }
}
