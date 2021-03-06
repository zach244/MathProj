package com.example.service;

import com.example.Repository.CorrectAnswerRepository;
import com.example.Repository.QuestionRepository;
import com.example.domain.CorrectAnswer;
import com.example.domain.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zach on 4/11/2017.
 */
@Service
@Transactional
public class CorrectAnswerService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CorrectAnswerRepository correctAnswerRepository;

    /**
     * checks to see whether there is a correct answer for a question already, if so it displayis in the log
     * if not it creates a new correct answer.
     *
     * @param answer
     * @param question
     * @return
     */
    @Transactional
    public CorrectAnswer createCorrectAnswer(int answer, Question question) {
        CorrectAnswer correctAnswer = correctAnswerRepository.findByQuestionId(question.getId());
        if (correctAnswer != null) {
            LOG.info("There is already a correct answer specified to this question, please delete or" +
                    "alter this correct answer");
        } else {
            correctAnswer = new CorrectAnswer(answer, questionRepository.findById(question.getId()));
            correctAnswerRepository.save(correctAnswer);
        }
        return correctAnswer;
    }
}
