package com.anisimovdenis.controller;

import com.anisimovdenis.service.UserDto;
import com.anisimovdenis.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    private List<UserDto> users;

    private UserDto userDto;

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        users = userService.findAll();
    }

    public String createUser() {
        this.userDto = new UserDto();
        return "/user_form.xhtml?faces-redirect=true";
    }

    public List<UserDto> getAllUsers() {
        return users;
    }

    public String editUser(UserDto userDto) {
        this.userDto = userDto;
        return "/user_form.xhtml?faces-redirect=true";
    }

    public void deleteUser(UserDto userDto) {
        userService.deleteById(userDto.getId());
    }

    public String saveUser() {
        userService.saveOrUpdate(userDto);
        return "/user.xhtml?faces-redirect=true";
    }
}
