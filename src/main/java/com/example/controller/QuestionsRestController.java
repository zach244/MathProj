package com.example.controller;

import com.example.Repository.QuestionRepository;
import com.example.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZACH on 3/24/2017.
 */


@RestController
@RequestMapping("/questions/")
public class QuestionsRestController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(method=RequestMethod.GET,value ="{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Question questionFind(@PathVariable int id)
    {
       return questionRepository.findOne(id);
    }

}