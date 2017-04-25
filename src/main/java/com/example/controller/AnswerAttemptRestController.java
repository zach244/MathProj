package com.example.controller;

import com.example.Repository.QuestionRepository;
import com.example.Repository.TestAttemptRepository;
import com.example.service.AnswerAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZACH on 4/4/2017.
 */

@RestController
@RequestMapping("api/answerattempt/")
public class AnswerAttemptRestController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestAttemptRepository testAttemptRepository;
    @Autowired
    private AnswerAttemptService answerAttemptService;

    /**
     * Rest method that takes a user answer, testattemptId and questionId to create an answer attempt using a post
     *
     * @param answer
     * @param testAttemptId
     * @param questionId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createAnswerAttempt(@RequestParam int answer,
                                             @RequestParam int testAttemptId,
                                             @RequestParam int questionId) {

        answerAttemptService.createAnswerAttempt(answer,
                testAttemptRepository.findById(testAttemptId),
                questionRepository.findById(questionId));
    }

}