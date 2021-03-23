package com.anisimovdenis.controller;

import com.anisimovdenis.service.RoleDto;
import com.anisimovdenis.service.RoleService;
import com.anisimovdenis.service.UserDto;
import com.anisimovdenis.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    @EJB
    private RoleService roleService;

    @Inject
    private HttpSession httpSession;

    private List<UserDto> users;

    private List<RoleDto> roles;

    private List<RoleDto> toSaveRoles;

    private UserDto userDto;

    public UserDto getUser() {
        return userDto;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public List<RoleDto> getToSaveRoles() {
        return toSaveRoles;
    }

    public void setToSaveRoles(List<RoleDto> toSaveRoles) {
        this.toSaveRoles = toSaveRoles;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        users = userService.findAll();
    }

    public void preloadRoles(ComponentSystemEvent componentSystemEvent) {
        roles = roleService.getAllRoles();
    }

    public String createUser() {
        this.userDto = new UserDto();
        return "/admin/user_form.xhtml?faces-redirect=true";
    }

    public List<UserDto> getAllUsers() {
        return users;
    }

    public String editUser(UserDto userDto) {
        this.userDto = userDto;
        return "/admin/user_form.xhtml?faces-redirect=true";
    }

    public void deleteUser(UserDto userDto) {
        userService.deleteById(userDto.getId());
    }

    public String saveUser() {
        userDto.setRoles(new HashSet<>(toSaveRoles));
        userService.saveOrUpdate(userDto);
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public String logout() {
        httpSession.invalidate();
        return "/product.xhtml?faces-redirect=true";
    }
}
