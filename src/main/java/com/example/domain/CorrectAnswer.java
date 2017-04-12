package com.example.domain;

import javax.persistence.*;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class CorrectAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int correctAnswer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")

    private Question question;

    public CorrectAnswer(int correctAnswer, Question question) {
        this.correctAnswer = correctAnswer;
        this.question = question;
    }

    public CorrectAnswer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "CorrectAnswer{" +
                "id=" + id +
                ", correctAnswer=" + correctAnswer +
                ", question=" + question.toString() +
                '}';
    }
}
