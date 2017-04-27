package com.example.service;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.Repository.UserRepository;
import com.example.domain.Category;
import com.example.domain.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional
public class TestService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * @param name
     * @param
     * @param category
     * @return
     */
    @Transactional
    public Test createTest(String name, Category category) {
        if (name == null || category == null) {
            LOG.info("Passed argument is null");
        }
        Test newTest = new Test(name, categoryRepository.findByName(category.getName()));
        testRepository.save(newTest);
        return newTest;
    }

    /**
     * finds all tests and returns them as a Set
     *
     * @return
     */
    @Transactional
    public List<Test> findAll() {
        List<Test> findAllTests = new ArrayList<>();
        for (Test test : testRepository.findAll()
                ) {
            findAllTests.add(test);

        }
        return findAllTests;
    }

    /**
     * finds a tests and delets it using its id
     * @param id
     */
    @Transactional
    public void deleteTest(int id) {
        testRepository.delete(testRepository.findById(id));
    }

}