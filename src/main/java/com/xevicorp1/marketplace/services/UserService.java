package com.xevicorp1.marketplace.services;

import com.xevicorp1.marketplace.models.User;
import com.xevicorp1.marketplace.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
}
