package com.example.service;

import com.example.domain.Test;
import com.example.domain.TestAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZACH on 4/27/2017.
 */
@Service
@Transactional
public class ProfileService {

    @Autowired
    private TestService testService;
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserService.class);
    @Autowired
    private TestAttemptService testAttemptService;
    @Autowired
    private UserService userService;

    @Transactional
    public List<TestAttempt> profileTestAttempts() {
        List<Test> tests = testService.findAll();
        List<TestAttempt> testAttempts = new ArrayList<>();
        for (Test t : tests
                ) {
            testAttempts.addAll(
                    testAttemptService.returnTestAttempts(
                            userService.getAuthenticatedUser(), t));
        }
        for (TestAttempt attempt : testAttempts
                ) {
            LOG.info(attempt.toString());
        }
        return testAttempts;
    }


}
