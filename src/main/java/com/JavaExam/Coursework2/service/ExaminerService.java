package com.JavaExam.Coursework2.service;

import com.JavaExam.Coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
