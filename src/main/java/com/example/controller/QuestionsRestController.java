package com.example.controller;

import com.example.domain.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZACH on 3/24/2017.
 */


@RestController
public class QuestionsRestController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method= RequestMethod.GET, value="/api/questions/{questionId}",produces = "application/json")
    @ResponseBody
    public Question getQuestion(@PathVariable("questionId") Long questionId)
    {   Question question = questionService.getQuestion(questionId);
        return question;
    }
}