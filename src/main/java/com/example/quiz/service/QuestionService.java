package com.example.quiz.service;

import com.example.quiz.dao.Questiondao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    Questiondao questiondao;
    public List<quiz_question> getAllquestion() {
        return questiondao.findAll();
    }

    public String addQuestion(quiz_question question) {
        questiondao.save(question);

        return "success";
    }

    public List<quiz_question> getQuestionByCategory(String category) {
        return questiondao.findByCategory(category);
    }

    @Transactional
    public String deleteQuestion(String category) {
        questiondao.deleteByCategory(category);
        return "deleted";
    }
}
