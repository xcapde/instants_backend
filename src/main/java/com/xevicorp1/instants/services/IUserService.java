package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.UserRequestDto;
import com.xevicorp1.instants.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getById(Long id);

    User create(UserRequestDto userDto);

}
