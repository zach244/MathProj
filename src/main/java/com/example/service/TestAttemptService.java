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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional
public class TestAttemptService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    @Autowired
    private TestAttemptRepository testAttemptRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserService userService;

    /**
     * Creates a new test attempt by receiving a test as a parameter creating a timestamp
     * gets the authentictad user by calling the .getAutenticatedUser() from userService and then finds the test
     * in the test repository and creates a new TestAttempt using all off the above information
     *
     * @param
     * @param
     * @param test
     * @return
     */
    @Transactional
    public TestAttempt createTestAttempt(Test test) {
        if (test == null) {
            LOG.info("argument passed can't be null");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TestAttempt testAttempt = new TestAttempt(
                userService.getAuthenticatedUser(),
                testRepository.findById(test.getId()), timestamp);
        testAttemptRepository.save(testAttempt);
        LOG.info(testAttempt.toString());
        return testAttempt;
    }

    /**
     * returns a list of all test attempts of a certain test, and a certain user
     *
     * @param user
     * @param test
     * @return
     */
    public List<TestAttempt> returnTestAttempts(User user, Test test) {
        List<TestAttempt> testAttempts = new ArrayList<>();
        for (TestAttempt ta : testAttemptRepository.findByUserIdAndTestId(user.getId(), test.getId()) //returns all test attempts made by a user and a certain test
                ) {
            testAttempts.add(ta);
        }
        return testAttempts;
    }

}
