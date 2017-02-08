package com.example.service;

import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by zach on 2/7/2017.
 */
@Service
public class UserSecurityService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       User user = userRepository.findByUsername(username);
        if(null == user)
        {
            throw new UsernameNotFoundException("Username" + username + " not found");

        }
        return user;
    }

}
