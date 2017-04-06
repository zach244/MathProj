package com.example.controller;

import com.example.Repository.TestRepository;
import com.example.service.TestAttemptService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZACH on 4/4/2017.
 */

@RestController
@RequestMapping("/tests/")
public class TestAttemptRestController {
@Autowired
private TestAttemptService testAttemptService;
@Autowired
private TestRepository testRepository;
@Autowired
private static final Logger LOG = LoggerFactory.getLogger(UserService.class); //need to look at

    @Autowired
   private UserService userService;

   @RequestMapping(method = RequestMethod.PUT, value ="{testId}")
   @ResponseStatus(value= HttpStatus.OK)
   public void createTestAttempt(@PathVariable int testId)
   {
       testAttemptService.createTestAttempt(testRepository.findById(testId)); //creates new test attempt by finding the test in the database
       LOG.info(testRepository.findById(testId).toString());   //Logs the test in console
      LOG.info(userService.getAuthenticatedUser().getUsername()); //Logs logged in username in console
   }
}
