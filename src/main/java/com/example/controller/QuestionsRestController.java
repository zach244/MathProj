package com.example.controller;

import com.example.Repository.QuestionRepository;
import com.example.domain.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZACH on 3/24/2017.
 */


@RestController
@RequestMapping("/questions/")
public class QuestionsRestController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    /**
     * gets a quesistion by id
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Question questionFind(@PathVariable int id) {
        return questionRepository.findOne(id);
    }

    /**
     * delets a test based on its id thats passed as a request param
     * @param questionId
     */
    @RequestMapping(method = RequestMethod.POST, value = "/delete/{questionId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteQuestion(@RequestParam int questionId) {
        questionService.deleteQuestion(questionId);
    }

    /**
     * Finds all the questions of a test that the id is passed as a path variable
     * @param testId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/fAll/{testId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Question> questionFindAll(@PathVariable int testId) {
        return questionService.testQuestions(testId);
    }

    /**
     * rest controller for modify takes all the RequestVaraibles and then uses the questionService to modify currently
     * not working
     * @param questionId
     * @param var1
     * @param var2
     * @param questionText
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modify/")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void modifyQuestionVar1(@RequestParam int questionId, @RequestParam int var1,
                                   @RequestParam int var2,
                                   @RequestParam String questionText) {
        questionService.modifyQuestion(questionId, var1, var2, questionText);
    }

}