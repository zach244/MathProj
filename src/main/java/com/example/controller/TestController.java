package com.example.controller;

import com.example.Repository.TestRepository;
import com.example.domain.Test;
import com.example.domain.User;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by zach on 3/19/2017.
 */

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String registration(Model model) {
       List<Test> testsAll = new LinkedList<>();
        for (Test test : testRepository.findAll()
             ) {
            testsAll.add(test);
        }
        model.addAttribute("testsAll",testsAll);

        return "tests";
    }
}