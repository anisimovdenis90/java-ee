package com.anisimovdenis.service;

import com.anisimovdenis.UserDto;
import com.anisimovdenis.persist.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserService {

    Long countAll();

    List<UserDto> findAll();

    User findById(Long id);

    void saveOrUpdate(UserDto user);

    void deleteById(Long id);
}
