package com.example.controller;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.domain.Test;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
                           @RequestParam String date,
                           @RequestParam String categoryName) throws ParseException {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateParsed = dt1.parse(date);
        return testService.createTest(name, dateParsed, categoryRepository.findByName(categoryName));
    }

}
