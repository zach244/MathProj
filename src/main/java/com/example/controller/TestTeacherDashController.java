package com.example.controller;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.domain.Test;
import com.example.service.CategoryService;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZACH on 4/18/2017.
 */
@Controller
public class TestTeacherDashController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/teachtestdash/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String registration(Model model) {
        List<Test> testsAll = new LinkedList<>();
        for (Test test : testRepository.findAll()
                ) {
            testsAll.add(test);
        }
        model.addAttribute("testsAll", testsAll);

        return "teachtestdash";
    }

    @RequestMapping(value = "/teachtestdash/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Test createTest(@RequestParam String name,
                           @RequestParam String categoryName) throws ParseException {

        if (categoryRepository.findByName(categoryName) == null) {
            categoryService.createCategory(categoryName);
            return testService.createTest(name, categoryRepository.findByName(categoryName));
        }
        return testService.createTest(name, categoryRepository.findByName(categoryName));
    }

    @RequestMapping(value = "/teachtestdash/delete/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteTest(@RequestParam int testId) throws ParseException {
        Test test = testRepository.findById(testId);
        testService.deleteTest(test);
    }
}
