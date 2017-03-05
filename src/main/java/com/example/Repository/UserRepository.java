package com.example.Repository;

import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zach on 2/7/2017.
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
