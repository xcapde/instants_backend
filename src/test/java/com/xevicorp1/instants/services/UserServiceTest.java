package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.UserRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @Mock
    IUserRepository mockUserRepository;

    @Test
    void getAllShouldReturnAnUserList() {
        var userService = new UserService(mockUserRepository);
        var userList = List.of(new User(), new User());

        Mockito.when(mockUserRepository.findAll()).thenReturn(userList);

        //SYSTEM UNDER TEST
        var sut = userService.getAll();

        //THEN
        assertThat(sut.size(), equalTo(2));
//        assertThat(sut.size(), equalTo(1)); // Perquè falli
    }
    @Test
    void getByIdShouldReturnAnUserWithSameId() {
        var userService = new UserService(mockUserRepository);
        var user = new User();
        var id = 1L;
        user.setId(id);

        Mockito.when(mockUserRepository.findById(id)).thenReturn(Optional.of(user));

        // SYSTEM UNDER TEST
        var sut = userService.getById(id);

        // THEN
        assertThat(sut.getId(),equalTo(1L) );
//        assertThat(sut.getId(),equalTo(2L) ); // Perquè falli
    }
    @Test
    void createSaveAnNewUserFromDTO() {
        var userService = new UserService(mockUserRepository);
        var userRequest = new UserRequestDto("Xavier","Patata","xavier.jpg","xavier@xavier.com","password");
        var createdUser = new User();
        createdUser.setName(userRequest.getName());
        createdUser.setSurname(userRequest.getSurname());
        createdUser.setAvatar(userRequest.getAvatar());
        createdUser.setMail(userRequest.getMail());
        createdUser.setPassword(userRequest.getPassword());

        Mockito.when(mockUserRepository.save(any(User.class))).thenReturn(createdUser);

        var sut = userService.create(userRequest);

        assertThat(sut.getName(), equalTo(createdUser.getName()));
//        assertThat(sut.getName(), equalTo(new User().getName())); // Perquè falli
    }
}