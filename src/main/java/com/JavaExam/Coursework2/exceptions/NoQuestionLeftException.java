package com.JavaExam.Coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoQuestionLeftException extends IllegalArgumentException {
    public NoQuestionLeftException(String message) {
        super(message);
    }
}

