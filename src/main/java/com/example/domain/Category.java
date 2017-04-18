package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZACH on 3/10/2017.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Test> testCategories = new HashSet<>();

    public Category() {
    }

    public Category(String name, Set<Test> testCategories) {
        this.name = name;
        this.testCategories = testCategories;
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Test> getTestCategories() {
        return testCategories;
    }

    public void setTestCategories(Set<Test> testCategories) {
        this.testCategories = testCategories;
    }

    @Override
    public String toString() {
        return name;
    }
}
