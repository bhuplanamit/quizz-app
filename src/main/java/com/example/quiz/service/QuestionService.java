package com.example.quiz.service;

import com.example.quiz.dto.QuestionResponse;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllquestion() {
        return questionRepository.findAll();
    }

    public QuestionResponse addQuestion(Question question) {
        Question saved = questionRepository.save(question);
        QuestionResponse.QuestionResponseBuilder builder = QuestionResponse.builder();
        if (Objects.nonNull(saved)) {
            builder.status("SUCCESS")
                    .data(saved).build();
        } else {
            builder.status("FAILURE");
        }
        return builder.build();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Transactional
    public QuestionResponse deleteQuestion(String category) {
        Question question = questionRepository.deleteByCategory(category);
        return QuestionResponse.builder().status("SUCCESS").data(question).build();
    }
}
