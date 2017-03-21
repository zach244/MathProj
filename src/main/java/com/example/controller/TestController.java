package com.example.controller;

import com.example.domain.Test;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by zach on 3/19/2017.
 */

@Controller
@RequestMapping("/tests")
public class TestController {
    @Autowired
  private TestService testService;
    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public Set<Test>getTests() {
        Set<Test> tests;
        tests = testService.findAll();
        return tests;
    }

public String tests()
{
    return "tests";
}
}
