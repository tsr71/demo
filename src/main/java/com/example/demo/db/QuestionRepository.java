package com.example.demo.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionRepository extends MongoRepository<Question, String> {

    @Query(" { 'question' : { $query: ?0 } } ")
    public List<Question> searchQuestion(String query);

}
