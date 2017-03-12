package com.example.Repository;

import com.example.domain.CorrectAnswer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ZACH on 3/10/2017.
 */

/**
 * Finds correct answer by id
 * Finds the answer by the foregin question key
 */
public interface CorrectAnswerRepository extends CrudRepository<CorrectAnswer,Long>
{
    CorrectAnswer findById(Long id);
    CorrectAnswer findByQuestionId(int question_id);
}
