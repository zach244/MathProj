package com.example.service;

import com.example.Repository.TestAttemptRepository;
import com.example.Repository.TestRepository;
import com.example.Repository.UserRepository;
import com.example.domain.Test;
import com.example.domain.TestAttempt;
import com.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional(readOnly = true)
public class TestAttemptService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private TestAttemptRepository testAttemptRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private UserService userService;

    public TestAttempt createTestAttempt(String attemptName, User user, Test test)
    {
       TestAttempt testAttempt = new TestAttempt(attemptName,
               userRepository.findByUsername(user.getUsername()),
               testRepository.findById(test.getId()));

        return testAttempt;
    }

}
