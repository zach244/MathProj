package com.example.Repository;

import com.example.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ZACH on 3/10/2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findById(int id);

    Category findByName(String name);
}
