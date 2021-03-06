package com.anisimovdenis.controller;

import com.anisimovdenis.persist.User;
import com.anisimovdenis.persist.UserRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {

    @Inject
    private UserRepository userRepository;

    private List<User> users;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        users = userRepository.findAll();
    }

    public String createUser() {
        this.user = new User();
        return "/user_form.xhtml?faces-redirect=true";
    }

    public List<User> getAllUsers() {
        return users;
    }

    public String editUser(User user) {
        this.user = user;
        return "/user_form.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }

    public String saveUser() {
        userRepository.saveOrUpdate(user);
        return "/user.xhtml?faces-redirect=true";
    }
}
