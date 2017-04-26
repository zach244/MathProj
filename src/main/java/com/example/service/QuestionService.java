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
                                   String questionText, Test test) {
        Test localTest = testRepository.findById(test.getId());
        if (localTest == null) {
            LOG.info("localTest is null");
        }
        Question localQuestion = new Question(variable1, variable2, questionText, localTest);
        questionRepository.save(localQuestion);
        return localQuestion;
    }

    /**
     * returns all the questions in a list based on a testId using question repository
     *
     * @param testId
     * @return
     */
    public List<Question> testQuestions(int testId) {
        List<Question> testQuestions = questionRepository.findByTestId(testId);
        return testQuestions;
    }

    /**
     * gets a certain question based on its id
     * @param questionId
     * @return
     */
    public Question getQuestion(int questionId) {
        Question question = questionRepository.findById(questionId);
        return question;
    }

    /**
     * deletes question based on its id
     * @param id
     */
    public void deleteQuestion(int id) {
        Question question = questionRepository.findById(id);
        questionRepository.delete(question);
    }

    /**
     * attempt at modifying question. Currently not working, takes and checks all the variables and modifies the question
     * based on the arguments passed
     * @param id
     * @param variable1
     * @param variable2
     * @param questionText
     */
    public void modifyQuestion(int id, int variable1, int variable2, String questionText) {

        if (questionRepository.findById(id) == null) {
            LOG.info("question hasn't been created");
        } else if (variable1 != 0 && variable2 == 0 && questionText == null) {
            Question question = questionRepository.findById(id);
            question.setVar1(variable1);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 != 0 && questionText == null) {
            Question question = questionRepository.findById(id);
            question.setVar2(variable2);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 == 0 && questionText != null) {
            Question question = questionRepository.findById(id);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else if (variable1 != 0 && variable2 != 0 && questionText == null) {
            Question question = questionRepository.findById(id);
            question.setVar1(variable1);
            question.setVar2(variable2);
            questionRepository.save(question);
        } else if (variable1 != 0 && variable2 == 0 && questionText != null) {
            Question question = questionRepository.findById(id);
            question.setVar1(variable1);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else if (variable1 == 0 && variable2 != 0 && questionText != null) {
            Question question = questionRepository.findById(id);
            question.setVar2(variable2);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        } else {
            Question question = questionRepository.findById(id);
            question.setVar1(variable1);
            question.setVar2(variable2);
            question.setQuestionText(questionText);
            questionRepository.save(question);
        }
    }

}