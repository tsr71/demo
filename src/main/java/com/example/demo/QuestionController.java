package com.example.demo;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.example.demo.db.Question;
import com.example.demo.db.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository repo;

    @PostConstruct
    public void init() {}

    @RequestMapping("/questions")
    public List<Question> getQuestions() {
        return repo.findAll();
    }

    @RequestMapping("/questions/")
    public List<Question> searchQuestion(@RequestParam("search") String search) {

        return repo.searchQuestion(search);

    }

    @RequestMapping(value = "/questions", method = POST)
    public void addQuestion(@RequestBody Question question) {
        repo.insert(question);
    }

    @RequestMapping(value = "/questions", method = PUT)
    public void updateQuestion(Question question) {
        repo.save(question);
    }

    @RequestMapping(value = "/questions", method = DELETE)
    public void deleteQuestion(Question question) {
        repo.delete(question);
    }



}
