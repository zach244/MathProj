package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class TestAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String attemptName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private Test test;
    @OneToMany(mappedBy = "testAttempt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AnswerAttempt> answerAttempts = new HashSet<>();

    public TestAttempt(String attemptName) {
        this.attemptName = attemptName;
    }

    public TestAttempt() {

    }

    public TestAttempt(String attemptName, User user, Test test) {
        this.attemptName = attemptName;
        this.user = user;
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttemptName() {
        return attemptName;
    }

    public void setAttemptName(String attemptName) {
        this.attemptName = attemptName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<AnswerAttempt> getAnswerAttempts() {
        return answerAttempts;
    }

    public void setAnswerAttempts(Set<AnswerAttempt> answerAttempts) {
        this.answerAttempts = answerAttempts;
    }

}
