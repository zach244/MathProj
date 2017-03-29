package com.example.service;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.domain.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;

/**
 * Created by zach on 3/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

   @Autowired
   private static UserService mockedUserService;

    @Before
    public void setUp() throws Exception {
    mockedUserService = mock(UserService.class);


    }




    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createUser() throws Exception {

    //assertEquals(user,userRepository.findByUsername(user.getUsername()));

    }

}