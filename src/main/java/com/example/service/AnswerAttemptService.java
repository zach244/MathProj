package com.example.service;

import com.example.Repository.AnswerAttemptRepository;
import com.example.Repository.QuestionRepository;
import com.example.Repository.TestAttemptRepository;
import com.example.domain.AnswerAttempt;
import com.example.domain.Question;
import com.example.domain.TestAttempt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zach on 3/12/2017.
 */
@Service
@Transactional
public class AnswerAttemptService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestAttemptRepository testAttemptRepository;
    @Autowired
    private AnswerAttemptRepository answerAttemptRepository;

    /**
     * Creates new answer attempt with finding test attempt id and question id
     * @param userAnswer
     * @param testAttempt
     * @param question
     * @return
     */
    @Transactional
    public AnswerAttempt createAnswerAttempt(int userAnswer, TestAttempt testAttempt,
                                             Question question)
    {
        if(testAttempt == null || question == null)
        {
            LOG.info("argument passed can't be null");
        }
        AnswerAttempt answerAttempt = new AnswerAttempt(userAnswer,
               testAttemptRepository.findById(testAttempt.getId()),
                questionRepository.findById(question.getId()));
        answerAttemptRepository.save(answerAttempt);
            return answerAttempt;
    }

}
