package com.example.controller;

import com.example.Repository.CorrectAnswerRepository;
import com.example.domain.CorrectAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zach on 4/11/2017.
 */
@RestController
@RequestMapping("/api/correctAnswer")
public class CorrectAnswerRestController {
    @Autowired
    private CorrectAnswerRepository correctAnswerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public CorrectAnswer getCorrectAnswer(@RequestParam int questionId) {
        return correctAnswerRepository.findByQuestionId(questionId);
    }

}
