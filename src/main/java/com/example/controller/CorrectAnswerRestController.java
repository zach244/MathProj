package com.example.controller;

import com.example.Repository.CorrectAnswerRepository;
import com.example.domain.CorrectAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zach on 4/11/2017.
 */
@RestController
@RequestMapping("/api/correctAnswer")
public class CorrectAnswerRestController {
    @Autowired
    private CorrectAnswerRepository correctAnswerRepository;

    //#TODO change to path variable
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CorrectAnswer getCorrectAnswer(@RequestParam int questionId) {
        return correctAnswerRepository.findByQuestionId(questionId);
    }

}
