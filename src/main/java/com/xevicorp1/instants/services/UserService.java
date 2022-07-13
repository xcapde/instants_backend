package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.UserRequestDto;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User create(UserRequestDto userDto) {
        var newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setSurname(userDto.getSurname());
        newUser.setAvatar(userDto.getAvatar());
        newUser.setMail(userDto.getMail());
        newUser.setPassword(userDto.getPassword());
        return userRepository.save(newUser);
    }
}
