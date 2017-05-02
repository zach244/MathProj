package com.example.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TestAttempt> testAttempts = new HashSet<>();
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> testQuestions = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Test() {
    }

    public Test(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Set<TestAttempt> getTestAttempts() {
        return testAttempts;
    }

    public void setTestAttempts(Set<TestAttempt> testAttempts) {
        this.testAttempts = testAttempts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Set<Question> getTestQuestions() {
        return testQuestions;
    }

    public void setTestQuestions(Set<Question> testQuestions) {
        this.testQuestions = testQuestions;
    }

    @Override
    public String toString() {
        return name;

    }
}
