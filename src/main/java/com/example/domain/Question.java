package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int var1;
    private int var2;
    private String questionText;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private Test test;
    @OneToOne(mappedBy = "question")
    private CorrectAnswer correctAnswer;
    @OneToMany(mappedBy = "question")
    private Set<AnswerAttempt> answerAttempts = new HashSet<>();



    public Question() {
    }

    public Question(int var1, int var2, String questionText, Test test) {
        this.var1 = var1;
        this.var2 = var2;
        this.questionText = questionText;
        this.test = test;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public CorrectAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Set<AnswerAttempt> getAnswerAttempts() {
        return answerAttempts;
    }

    public void setAnswerAttempts(Set<AnswerAttempt> answerAttempts) {
        this.answerAttempts = answerAttempts;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Question " + id +
                ", var1=" + var1 +
                ", var2=" + var2 +
                ", questionText='" + questionText + '\'' +
                ", test=" + test +
                '}';
    }
}
