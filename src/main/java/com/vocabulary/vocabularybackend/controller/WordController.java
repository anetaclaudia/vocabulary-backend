package com.vocabulary.vocabularybackend.controller;

import com.vocabulary.vocabularybackend.service.WordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // get mapping
    // post mapping
    // put mapping
}
