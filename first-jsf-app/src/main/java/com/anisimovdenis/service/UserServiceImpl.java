package com.anisimovdenis.service;

import com.anisimovdenis.persist.User;
import com.anisimovdenis.persist.UserRepository;
import com.anisimovdenis.rest.UserServiceRest;
import com.anisimovdenis.util.DtoUtil;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(UserServiceRemote.class)
public class UserServiceImpl implements UserService, UserServiceRest, UserServiceRemote {

    @EJB
    private UserRepository userRepository;

    @Override
    public Long countAll() {
        return userRepository.countAll();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(DtoUtil::buildUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return DtoUtil.buildUserDto(userRepository.findById(id));
    }

    @Override
    public void insert(UserDto userDto) {
        if (userDto.getId() != null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(userDto);
    }

    @Override
    public void update(UserDto userDto) {
        if (userDto.getId() == null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(userDto);
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
