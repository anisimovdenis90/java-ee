package com.anisimovdenis.service;

import java.util.List;

public interface UserServiceRemote {

    Long countAll();

    List<UserDto> findAll();

    UserDto findById(Long id);
}
