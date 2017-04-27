package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class TestAttempt { //issues with circular dependencies
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private int numOfQuestions;
    private int numOfCorrectQuestions;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @JsonBackReference
    @OneToMany(mappedBy = "testAttempt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AnswerAttempt> answerAttempts = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_FIELD")
    private java.util.Date timestampField;


    public TestAttempt() {

    }


    public TestAttempt(User user, int numOfQuestions, Test test) {
        this.user = user;
        this.numOfQuestions = numOfQuestions;
        this.numOfCorrectQuestions = 0;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public int getNumOfCorrectQuestions() {
        return numOfCorrectQuestions;
    }

    public void setNumOfCorrectQuestions(int numOfCorrectQuestions) {
        this.numOfCorrectQuestions = numOfCorrectQuestions;
    }

    @Override
    public String toString() {
        return "TestAttempt{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", test=" + test.toString() +
                '}';
    }
}
