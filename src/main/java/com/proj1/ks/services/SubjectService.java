package com.proj1.ks.services;

import com.proj1.ks.model.Subject;
import com.proj1.ks.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id){
        return subjectRepository.findById(id);
    }
}
