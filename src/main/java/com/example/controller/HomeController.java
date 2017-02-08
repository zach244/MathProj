package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zach on 2/7/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/payload")
    public String payload()
    {
        return "payload";
    }
}
