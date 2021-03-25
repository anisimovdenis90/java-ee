package com.anisimovdenis.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserService {

    Long countAll();

    List<UserDto> findAll();

    UserDto findById(Long id);

    void saveOrUpdate(UserDto user);

    void deleteById(Long id);
}
