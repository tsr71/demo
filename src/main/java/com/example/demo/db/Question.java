package com.example.demo.db;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question implements Serializable {

    @Id
    private String id;
    private String question;
    private List<Answer> answers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {this.answers.add(answer);}
    public void deleteAnswer(Answer answer) {this.answers.remove(answer);}
}
