package com.example.quiz.dao;

import com.example.quiz.service.quiz_question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Questiondao extends JpaRepository<quiz_question,Integer> {
    List<quiz_question> findByCategory(String category);


    void deleteByCategory(String category);
}
