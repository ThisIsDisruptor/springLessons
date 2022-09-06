package com.example.demo.service.impl;

import com.example.demo.model.Task;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
    public void getCurrentUser_whenUserExists_returnCorrectUser() {
        //arrange
        User stubUser = createStubUser();
        Mockito.doReturn(Optional.of(stubUser)).when(userRepository).findByLogin(MOCK_USER_NAME);

        //act
        User foundedUser = userService.getCurrentUser();

        //assert
        Mockito.verify(userRepository).findByLogin(MOCK_USER_NAME);
        Assertions.assertEquals(MOCK_USER_NAME, foundedUser.getLogin());
    }

    @Test
    @WithMockUser(MOCK_USER_NAME)
    public void getCurrentUser_whenUserDoesNotExist_throwsException() {
        //assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            //act
            User foundedUser = userService.getCurrentUser();
        });

        String expectedMessage = "user not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @WithMockUser(MOCK_USER_NAME)
    public void getCurrentUserTasks_whenUserExists_returnsListTask() {
        //arrange
        User stubUser = createStubUserWithTasks();
        Mockito.doReturn(Optional.of(stubUser)).when(userRepository).findByLogin(MOCK_USER_NAME);

        //act
        List<Task> tasks = userService.getCurrentUserTasks();

        //assert
        assertEquals(stubUser.getTasks(), tasks);
    }

    private User createStubUser() {
        User stubUser = new User();
        stubUser.setId(1l);
        stubUser.setLogin(MOCK_USER_NAME);
        stubUser.setPassword("Qwerty123!");
        return stubUser;
    }

    private List<Task> createStubTaskList() {
        Task stubTask = new Task();
        List<Task> stubTaskList = List.of(stubTask);
        return stubTaskList;
    }

    private User createStubUserWithTasks() {
        User stubUser = createStubUser();
        List<Task> stubTaskList = createStubTaskList();
        stubUser.setTasks(stubTaskList);
        return stubUser;
    }

}
