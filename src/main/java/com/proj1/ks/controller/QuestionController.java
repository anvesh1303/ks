package com.proj1.ks.controller;

import com.proj1.ks.model.Question;
import com.proj1.ks.repository.QuestionRepository;
import com.proj1.ks.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/{subjectId}")
    public List<Question> getQuestionsBySubjectId(@PathVariable Long subjectId){
        System.out.println("Getting questions for subject ID: " + subjectId);
        return questionService.getQuestionsBySubjectId(subjectId);
    }
}
