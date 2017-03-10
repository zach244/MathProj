package com.example.Repository;

import com.example.domain.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ZACH on 3/9/2017.
 */
public interface QuestionRepository extends CrudRepository<Question,Long>{
    Question findByTestId(Long test_id);
}
