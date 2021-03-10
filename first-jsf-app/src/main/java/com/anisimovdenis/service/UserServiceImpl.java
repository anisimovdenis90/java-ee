package com.anisimovdenis.service;

import com.anisimovdenis.persist.User;
import com.anisimovdenis.persist.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserServiceImpl implements UserService {

    @EJB
    private UserRepository userRepository;

    @Override
    public Long countAll() {
        return userRepository.countAll();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @TransactionAttribute
    public void saveOrUpdate(UserDto userDto) {
        userRepository.saveOrUpdate(new User(userDto));
    }

    @Override
    @TransactionAttribute
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
