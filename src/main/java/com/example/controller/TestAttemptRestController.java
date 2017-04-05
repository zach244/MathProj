package com.example.controller;

import com.example.Repository.TestRepository;
import com.example.service.TestAttemptService;
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

   @RequestMapping(method = RequestMethod.PUT, value ="{testId}")
   @ResponseStatus(value= HttpStatus.OK)
   public void createTestAttempt(@PathVariable int testId)
   {
       testAttemptService.createTestAttempt(testRepository.findById(testId));
   }
}
