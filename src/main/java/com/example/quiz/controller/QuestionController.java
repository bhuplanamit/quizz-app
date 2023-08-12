package com.example.quiz.controller;

import com.example.quiz.service.QuestionService;

import com.example.quiz.service.quiz_question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping( "allquestion")
    public List<quiz_question> getAllquestion(String category){
        System.out.println(category);
        return questionService.getAllquestion();
    }
    @PostMapping("add")
    public String addQuestion(@RequestBody quiz_question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("category/{category}")
    public List<quiz_question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
    @DeleteMapping("deletequestion/{category}")
    public String deleteQuestion( @PathVariable String category){
        return questionService.deleteQuestion(category);
    }
}
