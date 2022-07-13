package com.xevicorp1.instants.services;

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
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @Mock
    IUserRepository mockUserRepository;

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
}