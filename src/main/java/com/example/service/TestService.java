package com.example.service;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.domain.Category;
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
public class TestService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestRepository testRepository;
    @Transactional
    public Test createTest(Test test, Category category)
    {   Category newCategory = categoryRepository.findByName(category.getName());
        Test newTest = testRepository.findById(test.getId());
        if(test == null || category == null)
        {
        LOG.info("test or category can't be null");
        }
        else{                                   //issue with nullpointer some where in here
            newTest.setCategory(newCategory);
            newTest = testRepository.save(test);
    }
            return newTest;
    }
}
