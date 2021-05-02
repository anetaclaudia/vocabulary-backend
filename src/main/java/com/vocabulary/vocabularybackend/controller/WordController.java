package com.vocabulary.vocabularybackend.controller;

import com.vocabulary.vocabularybackend.dto.WordDto;
import com.vocabulary.vocabularybackend.mapper.WordMapper;
import com.vocabulary.vocabularybackend.model.Language;
import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.service.WordService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordController {

    private final WordService wordService;

    // private final WordMapper mapper = Mappers.getMapper(WordMapper.class);

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // /words?word=test&language=ENG
    // /words?word=test&language=EST
    @GetMapping
    public List<Word> getWords(@RequestParam String word, @RequestParam(defaultValue = "EST") Language language){
        // return wordService.findExactMatches(word, language);
        return wordService.findFuzzyMatches(word, language);
    }

    @PostMapping
    public Word saveWord(@RequestBody Word word){
        return wordService.saveWord(word);
    }
}
