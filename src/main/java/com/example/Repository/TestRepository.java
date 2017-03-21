package com.example.Repository;

import com.example.domain.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by ZACH on 3/10/2017.
 */
public interface TestRepository extends CrudRepository<Test, Integer> {
    List<Test> findByCategory(int category_id);
    Test findById(int id);
    List<Test> findByDate(Date date);
    Test findByName(String name);
    List<Test> findAll();
}
