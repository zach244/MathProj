package com.example.domain;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testattempt_id")
    private TestAttempt testAttempt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question2;

    public AnswerAttempt() {
    }

    public AnswerAttempt(int userAnswer, TestAttempt testAttempt, Question question2) {
        this.userAnswer = userAnswer;
        this.testAttempt = testAttempt;
        this.question2 = question2;
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

    public Question getQuestion2() {
        return question2;
    }

    public void setQuestion2(Question question2) {
        this.question2 = question2;
    }
}
