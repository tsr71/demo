package com.example.demo.db;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String userName;
    private Set<Question> questions;
    private Set<Answer> answers;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Set<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    public void removeQuestion(Question question) { this.questions.remove(question); }


    public Set<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

}
