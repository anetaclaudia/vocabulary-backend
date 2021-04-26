package com.vocabulary.vocabularybackend.exception;

public class WordNotFoundException extends Exception{
    public WordNotFoundException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
