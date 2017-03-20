package com.example.controller;

import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zach on 3/19/2017.
 */

@Controller
//@RequestMapping("/tests")
public class TestController {
    @Autowired
  private TestService testService;




}
