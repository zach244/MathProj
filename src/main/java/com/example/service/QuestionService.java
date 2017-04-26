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
     *
     * @param variable1
     * @param variable2
     * @param questionText
     * @param test
     * @return
     */
    @Transactional
    public Question createQuestion(int variable1, int variable2,
                                   String questionText, Test test)
    {
        Test localTest = testRepository.findById(test.getId());
        if (localTest == null) {
            LOG.info("localTest is null");
        }
        Question localQuestion = new Question(variable1, variable2, questionText, localTest);
        questionRepository.save(localQuestion);
        return localQuestion;
    }

    public List<Question> testQuestions(int testId) {
        List<Question> testQuestions = questionRepository.findByTestId(testId);
        return testQuestions;
    }

    public Question getQuestion(int questionId) {
        Question question = questionRepository.findById(questionId);
        return question;
    }

    public void deleteQuestion(int id) {
        Question question = questionRepository.findById(id);
        questionRepository.delete(question);
    }

    public void modifyQuestion(int id, int variable1, int variable2, String questionText) {
        Question question = questionRepository.findById(id);
        if (questionRepository.findById(id) == null) {
            LOG.info("question hasn't been created");
        } else if (variable1 != 0 && variable2 == 0 && questionText == null) {
            question.setVar1(variable1);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 != 0 && questionText == null) {
            question.setVar2(variable2);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 == 0 && questionText != null) {
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else if (variable1 != 0 && variable2 != 0 && questionText == null) {
            question.setVar1(variable1);
            question.setVar2(variable2);
            questionRepository.save(question);
        } else if (variable1 != 0 && variable2 == 0 && questionText != null) {
            question.setVar1(variable1);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 != 0 && questionText != null) {
            question.setVar2(variable2);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else {
            question.setVar1(variable1);
            question.setVar2(variable2);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        }
    }

}