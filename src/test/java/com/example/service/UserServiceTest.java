package com.example.service;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.domain.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zach on 3/16/2017.
 */
public class UserServiceTest {

    User user;
    @Autowired
    UserRole userRole;
    @Autowired
    Role role;
    @Autowired
    UserService userService;

    

    @Before
    public void setUp() throws Exception {
//    user = new User();
//    user.setUsername("Test");
//    user.setPassword("Test");
//    role = new Role();
//    role.setName("Admin");
//    Set<UserRole> userRoles = new HashSet<>();
//    userRole = new UserRole(user,role);
//    userRoles.add(userRole);
//    userService.createUser(user,userRoles);


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createUser() throws Exception {

    //assertEquals(user,userRepository.findByUsername(user.getUsername()));

    }

}