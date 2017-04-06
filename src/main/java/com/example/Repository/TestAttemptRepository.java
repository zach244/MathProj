package com.example.Repository;

import com.example.domain.TestAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ZACH on 3/10/2017.
 */
public interface TestAttemptRepository extends CrudRepository<TestAttempt,Long>{
    TestAttempt findById(Long id);
    List<TestAttempt> findByUserIdAndTestId(Long user_id,int test_id);
}
