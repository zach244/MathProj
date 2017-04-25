package com.example.controller;

import com.example.domain.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zach on 4/18/2017.
 */
@RestController
@RequestMapping("api/categories/")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Category> categoriesList() {
        return categoryService.findCategories();
    }

}
