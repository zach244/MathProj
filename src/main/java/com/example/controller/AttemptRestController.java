package com.example.controller;

import com.example.Repository.AnswerAttemptRepository;
import com.example.Repository.QuestionRepository;
import com.example.Repository.TestRepository;
import com.example.domain.AnswerAttempt;
import com.example.domain.Question;
import com.example.domain.Test;
import com.example.domain.TestAttempt;
import com.example.service.AnswerAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZACH on 4/4/2017.
 */
//@RestController
////@RequestMapping("tests/{testId}/anserAttempt/")
////public class AttemptRestController {
////    @Autowired
////    private AnswerAttemptRepository answerAttemptRepository;
////
////    @Autowired
////    private QuestionRepository  questionRepository;
////
////    @Autowired
////    private AnswerAttemptService answerAttemptService;
////
////    @Autowired
////    private TestRepository testRepository;
////
////
////    @RequestMapping(method= RequestMethod.PUT,value ="{questionId}")
////    public AnswerAttempt createAnswerAttempt(@RequestParam int answer,@PathVariable int testId, @RequestParam int questionId)
////    {
////        Question question = questionRepository.findById(questionId);
////
////    }
////
////
////
////}
