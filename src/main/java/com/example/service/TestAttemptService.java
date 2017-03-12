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
@Transactional
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

    /**
     * Creates new test attempt by using repositories to find user
     * and test then saves them in object
     * @param attemptName
     * @param user
     * @param test
     * @return
     */
    public TestAttempt createTestAttempt(String attemptName, User user, Test test)
    {   if(attemptName == null || user == null || test == null)
    {
        LOG.info("argument passed can't be null");
    }
       TestAttempt testAttempt = new TestAttempt(attemptName,
               userRepository.findByUsername(user.getUsername()),
               testRepository.findById(test.getId()));
        testAttemptRepository.save(testAttempt);
        return testAttempt;
    }
      //TODO
//    public List<TestAttempt> returnTestAttempts(User user,Test test)
//    {
//        List<TestAttempt> testAttempts = testAttemptRepository.findByUserIdAndTestId(test.getId(),
//                user.getId()); // issue with this method
//        return testAttempts;
//    }
}
