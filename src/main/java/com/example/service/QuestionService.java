package com.example.service;

import com.example.Repository.QuestionRepository;
import com.example.Repository.TestRepository;
import com.example.domain.Question;
import com.example.domain.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional(readOnly = true)
public class QuestionService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public Question createQuestion(Question question, Test test)
    {   Question localQuestion = questionRepository.findById(question.getId());
        Test localTest = testRepository.findById(test.getId());
        if(question == null || test == null)
        {
            LOG.info("The question can't be null or Test can't be null");
        }
        else
        {
            localQuestion.setTest(test);
            localQuestion = questionRepository.save(question);
        }
        return localQuestion;
    }
}
