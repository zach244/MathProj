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

import java.util.List;

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

    /**
     * Creates a new questions if the test passed as an argument wasn't null.
     * @param variable1
     * @param variable2
     * @param questionText
     * @param test
     * @return
     */
    @Transactional
    public Question createQuestion(int variable1,int variable2,
                                   String questionText, Test test) //issue with getting test id
    {
        Test localTest = testRepository.findById(test.getId());
        if(localTest == null)
        {
            LOG.info("localTest is null");
        }
        Question localQuestion = new Question(variable1,variable2,questionText,localTest);
        questionRepository.save(localQuestion);
        return localQuestion;
    }
    public List<Question> testQuestions(Test test)
    {
        List<Question> testQuestions = questionRepository.findByTestId(test.getId());
        return testQuestions;
    }

}
