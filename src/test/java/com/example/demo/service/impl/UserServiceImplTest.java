package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    private final String MOCK_USER_NAME = "mock";

    
    @Test
    public void create_whenCreateUser_userSavedWithEncodedPassword() {
        //arrange
        User user = new User();
        user.setId(1l);
        user.setLogin("mock");
        user.setPassword("Qwerty123!");
        String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";
        Mockito.doReturn(encodedPassword).when(passwordEncoder)
                .encode(user.getPassword());

        //act
        userService.create(user);

        //assert
        Mockito.verify(userRepository).save(user);
        Assertions.assertEquals(encodedPassword, user.getPassword());
    }

    @Test
    @WithMockUser(MOCK_USER_NAME)
    public void getCurrentUser_whenUserExists_ReturnCorrectUser() {
        //arrange
        User stubUser = new User();
        stubUser.setId(1l);
        stubUser.setLogin(MOCK_USER_NAME);
        stubUser.setPassword("Qwerty123!");
        Mockito.doReturn(Optional.of(stubUser)).when(userRepository).findByLogin(MOCK_USER_NAME);

        //act
        User foundedUser = userService.getCurrentUser();

        //assert
        Mockito.verify(userRepository).findByLogin(MOCK_USER_NAME);
        Assertions.assertEquals(MOCK_USER_NAME, foundedUser.getLogin());
    }

    @Test
    @WithMockUser(MOCK_USER_NAME)
    public void getCurrentUser_whenUserDoesNotExist_ThrowsException() {
        //assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User foundedUser = userService.getCurrentUser();
        });

        String expectedMessage = "user not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
