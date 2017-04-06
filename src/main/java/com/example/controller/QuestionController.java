package com.example.controller;

import com.example.Repository.TestRepository;
import com.example.domain.Question;
import com.example.domain.Test;
import com.example.service.QuestionService;
import com.example.service.TestAttemptService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zach on 3/21/2017.
 */



@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class); //need to look at
    @Autowired
    private TestAttemptService testAttemptService;
    @Autowired
    private TestRepository testRepository;

    /**
     * When a test in the table is clicked on, this gets all the questions from the certain test, and adds them to the new model as a list
     * then a new TestAttempt is created based on the logged in user using .getAuthenticatedUser(), and the id passed as a path variable
     * View returned is the questions.html
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value ="/tests/{id}", method = RequestMethod.GET)
    public String questions(@PathVariable("id")int id,Model model)
    {   List<Question> questionsList = new LinkedList<>();
        for (Question question: questionService.testQuestions(id)
             ) {
            questionsList.add(question);
        }
        model.addAttribute("questionList",questionsList);
//        LOG.info(userService.getAuthenticatedUser().getUsername()); used to check the authenticated user is correct
        testAttemptService.createTestAttempt(testRepository.findById(id));
        return "questions";
    }
//    @RequestMapping(value="/tests/{testid}/{questionid}", method = RequestMethod.GET)
//    public String questionInfo(@PathVariable("testid")int testid,@PathVariable("questionid") int questionid,Model model)
//    {
//
//        return "questions";
//    }

}
