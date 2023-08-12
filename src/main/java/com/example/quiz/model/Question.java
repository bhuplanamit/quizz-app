package com.example.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "quiz_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String category;

    @Column(name = "difficulylevel")
    private String difficulyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
