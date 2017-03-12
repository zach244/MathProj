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

import java.util.Date;

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

    /**
     * This method createse a new Test object with the passed parameters.
     * @param name
     * @param date
     * @param category
     * @return Test
     */
    @Transactional
    public Test createTest(String name, Date date, Category category) {
        Test newTest = new Test();
        newTest.setName(name);
        newTest.setDate(date);
        Category newCategory = categoryRepository.findByName(category.getName());
        newTest.setCategory(newCategory);
        testRepository.save(newTest);
        return newTest;
    }
}