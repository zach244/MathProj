package com.example.controller;

import com.example.Repository.TestRepository;
import com.example.domain.TestAttempt;
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
@RequestMapping("api/testattempt/")
public class TestAttemptRestController {
@Autowired
private TestAttemptService testAttemptService;
@Autowired
private TestRepository testRepository;
@Autowired
private static final Logger LOG = LoggerFactory.getLogger(UserService.class); //need to look at

   /**
    * Method that takes a Pathvariable of int which should be the TestID Then creates a TestAttempt based
    * on the Id
    *
    * @param testId
    * @return TestAttempt
    */
   @RequestMapping(method = RequestMethod.POST, value = "{testId}")
   @ResponseStatus(value= HttpStatus.OK)
   public TestAttempt createTestAttempt(@PathVariable int testId) {
      return testAttemptService.createTestAttempt(testRepository.findById(testId));
   }
}
