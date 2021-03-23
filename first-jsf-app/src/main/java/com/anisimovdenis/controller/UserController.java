package com.anisimovdenis.controller;

import com.anisimovdenis.service.*;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

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

    private UserDto userDto;

    public UserDto getUser() {
        return userDto;
    }

    public List<RoleDto> getRoles() {
        return roles;
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
        userService.saveOrUpdate(userDto);
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public String logout() {
        httpSession.invalidate();
        return "/product.xhtml?faces-redirect=true";
    }
}
