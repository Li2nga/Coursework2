package com.JavaExam.Coursework2.service;

import com.JavaExam.Coursework2.exceptions.NoQuestionLeftException;
import com.JavaExam.Coursework2.exceptions.NullQuestionIsNotAllowedException;
import com.JavaExam.Coursework2.exceptions.QuestionAlreadyExistsException;
import com.JavaExam.Coursework2.exceptions.QuestionIsNotInTheBookException;
import com.JavaExam.Coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionsBook = new HashSet<>();
    private Object question;

    @Override
    public Question add(String question, String answer) {
        if (question == null) {
            throw new NullQuestionIsNotAllowedException("Question is null");
        }
        Question newQuestion = new Question(question, answer);
        if (questionsBook.add(newQuestion)) {
            return newQuestion;
        } else {
            throw new QuestionAlreadyExistsException("Question already exists in the questionsBook");
        }
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullQuestionIsNotAllowedException("Question is null");
        }
        if (questionsBook.add(question)) {
            return question;
        } else {
            throw new QuestionAlreadyExistsException("Question already exists in the questionsBook");
        }
    }

    @Override
    public Question remove(Question question) {

        if (questionsBook.remove(question)) {
            return question;
        } else {
            throw new QuestionIsNotInTheBookException("Question doesn't exists in the questionsBook");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsBook);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsBook.isEmpty()) {
            throw new NoQuestionLeftException("QuestionsBook is empty");
        }
        Random random = new Random();
        return (Question) questionsBook.toArray()[random.nextInt(questionsBook.size())];
    }
}
