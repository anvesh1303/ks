package com.proj1.ks.services;

import com.proj1.ks.model.Question;
import com.proj1.ks.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestionsBySubjectId(Long subjectId){
        return questionRepository.findBySubjectId(subjectId);
    }

}
