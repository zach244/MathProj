package com.example.controller;

import com.example.domain.Question;
import com.example.domain.Test;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value ="/questions", method = RequestMethod.GET)
    public String questions(Test test, Model model)
    {   List<Question> questionsList = new LinkedList<>();
        for (Question question: questionService.testQuestions(test)
             ) {
            questionsList.add(question);

        }
        model.addAttribute("questionList",questionsList);
        return "questions";
    }
}
