package com.example.service;

import com.example.Repository.RoleRepository;
import com.example.Repository.UserRepository;
import com.example.domain.User;
import com.example.domain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


/**
 * Created by zach on 2/7/2017.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class); //need to look at
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * checks to see if the user has already been created, if it has been created, throws error message in log, if not
     * creates a new user with the passed arguments
     * @param user
     * @param userRoles
     * @return
     */
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());

        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
