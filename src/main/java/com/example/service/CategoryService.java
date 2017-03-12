package com.example.service;

import com.example.Repository.CategoryRepository;
import com.example.domain.Category;
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
public class CategoryService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional
    public Category createCategory(String name)
    {    Category newCategory = categoryRepository.findByName(name);
            Category category = new Category(name);
        if(name == null)
        {
            LOG.info("Category can't be null");
        }
        if(newCategory != null)
        {
            LOG.info("Category has already been created");
        }
        else{

            categoryRepository.save(category);
        }
            return category;
    }
}
