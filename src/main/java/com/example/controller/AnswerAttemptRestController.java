package com.example.controller;

import com.example.Repository.AnswerAttemptRepository;
import com.example.Repository.QuestionRepository;
import com.example.Repository.TestAttemptRepository;
import com.example.Repository.TestRepository;
import com.example.domain.AnswerAttempt;
import com.example.service.AnswerAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZACH on 4/4/2017.
 */
@RestController
@RequestMapping("api/anserAttempt/")
public class AnswerAttemptRestController {


    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerAttemptService answerAttemptService;

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private AnswerAttemptRepository answerAttemptRepository;
    @Autowired
    private TestAttemptRepository testAttemptRepository;


    @RequestMapping(method = RequestMethod.POST)
    public AnswerAttempt createAnswerAttempt(@RequestParam int answer,
                                             @RequestParam int testAttemptId,
                                             @RequestParam int questionId) {
        AnswerAttempt answerAttempt = new AnswerAttempt(answer,
                testAttemptRepository.findById(testAttemptId),
                questionRepository.findById(questionId));
        answerAttemptRepository.save(answerAttempt);
        return answerAttempt;
    }

}