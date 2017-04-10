package com.example.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class AnswerAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int userAnswer;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testattempt_id")
    private TestAttempt testAttempt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public AnswerAttempt() {
    }

    public AnswerAttempt(int userAnswer, TestAttempt testAttempt, Question question) {
        this.userAnswer = userAnswer;
        this.testAttempt = testAttempt;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public TestAttempt getTestAttempt() {
        return testAttempt;
    }

    public void setTestAttempt(TestAttempt testAttempt) {
        this.testAttempt = testAttempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
