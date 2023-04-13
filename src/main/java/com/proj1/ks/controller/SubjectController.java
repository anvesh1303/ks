package com.proj1.ks.controller;

import com.proj1.ks.model.Subject;
import com.proj1.ks.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
        Optional<Subject> subject = subjectService.getSubjectById(id);
        return subject.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
