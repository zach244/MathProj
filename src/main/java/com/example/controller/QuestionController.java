package com.example.controller;

import com.example.domain.Question;
import com.example.domain.Test;
import com.example.service.QuestionService;
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

    @RequestMapping(value ="/tests/{id}", method = RequestMethod.GET)
    public String questions(@PathVariable("id")int id,Model model)
    {   List<Question> questionsList = new LinkedList<>();
        for (Question question: questionService.testQuestions(id)
             ) {
            questionsList.add(question);
        }
        model.addAttribute("questionList",questionsList);
        return "questions";
    }
    @RequestMapping(value="/tests/{testid}/{questionid}", method = RequestMethod.GET)
    public String questionInfo(@PathVariable("testid")int testid,@PathVariable("questionid") int questionid,Model model)
    {

        return "questions";
    }

}
