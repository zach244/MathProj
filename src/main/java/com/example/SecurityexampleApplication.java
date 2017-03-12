package com.example;

import com.example.domain.Category;
import com.example.domain.Test;
import com.example.service.CategoryService;
import com.example.service.QuestionService;
import com.example.service.TestService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SecurityexampleApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(SecurityexampleApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setName("Addition");
        categoryService.createCategory(category);


        String date_s = "2011-01-18 00:00:00.0";
        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");


        Test test = testService.createTest("test 1", date, category);


       questionService.createQuestion(3,4,"Please add 3 and 4 together",test);//Need to create Test service
    }
}