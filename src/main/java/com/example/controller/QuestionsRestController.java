package com.example.controller;

import com.example.Repository.QuestionRepository;
import com.example.domain.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public Question questionFind(@PathVariable int id)
    {
       return questionRepository.findOne(id);
    }


}