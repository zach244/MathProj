package com.example.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.User;

/**
 * Created by zach on 2/7/2017.
 */

public interface UserRepository extends CrudRepository<User,Long>{
   User findByUsername (String username);

}
