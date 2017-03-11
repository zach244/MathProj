package com.example.Repository;

import com.example.domain.AnswerAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ZACH on 3/10/2017.
 */
public interface AnswerAttemptRepository extends CrudRepository<AnswerAttempt, Long> {
    List<AnswerAttempt> findById(Long id);
    AnswerAttempt findByUserAnswer(int userAnswer);
    AnswerAttempt findByTestAttemptId(int testattempt_id);
    List<AnswerAttempt> findByQuestionId(int question_id);
    List<AnswerAttempt> findByQuestionIdAndTestAttemptId(int question_id,
                                                         int testattempt_id);

}
