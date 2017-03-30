package com.example.Repository;

import com.example.domain.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ZACH on 3/9/2017.
 */

/**
 * Finds by foreign key and returns a list of quetions on a test.
 * Finds a certain question by id
 */
public interface QuestionRepository extends CrudRepository<Question,Integer>{
   List<Question> findByTestId(int test_id);
   Question findById(int id);
}
