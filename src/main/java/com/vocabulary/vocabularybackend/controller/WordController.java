package com.vocabulary.vocabularybackend.controller;

import com.vocabulary.vocabularybackend.mapper.WordMapper;
import com.vocabulary.vocabularybackend.service.WordService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("words")
public class WordController {

    private final WordService wordService;

    private final WordMapper mapper = Mappers.getMapper(WordMapper.class);

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // get mapping


    // post mapping
    // put mapping
}
