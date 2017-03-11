package com.example.Repository;

import com.example.domain.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ZACH on 3/9/2017.
 */
public interface QuestionRepository extends CrudRepository<Question,Long>{
   List<Question> findByTestId(int test_id);

   Question findById(Long id);

   Question findByName(String name);
}
