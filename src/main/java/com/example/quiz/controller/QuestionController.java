package com.example.quiz.controller;

import com.example.quiz.dto.QuestionResponse;
import com.example.quiz.service.QuestionService;

import com.example.quiz.model.Question;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@Log4j2
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allquestion")
    public List<Question> getAllQuestions() {
        log.info("Fetching all questions.");
        return questionService.getAllquestion();
    }

    @PostMapping("add")
    public QuestionResponse addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        log.info("Fetching questions by category: {}", category);
        return questionService.getQuestionByCategory(category);
    }

    @DeleteMapping("deletequestion/{category}")
    public QuestionResponse deleteQuestion(@PathVariable @NonNull String category) {
        log.info("Deleting questions by category: {}", category);
        return questionService.deleteQuestion(category);
    }
}
