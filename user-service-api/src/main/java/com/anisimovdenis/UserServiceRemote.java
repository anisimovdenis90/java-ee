package com.anisimovdenis;

import java.util.List;

public interface UserServiceRemote {

    Long countAll();

    List<UserDto> findAll();

    UserDto findById(Long id);
}
