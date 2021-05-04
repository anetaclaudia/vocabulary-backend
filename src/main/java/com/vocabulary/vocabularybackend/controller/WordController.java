package com.vocabulary.vocabularybackend.controller;

import com.vocabulary.vocabularybackend.dto.WordDto;
import com.vocabulary.vocabularybackend.mapper.WordMapper;
import com.vocabulary.vocabularybackend.model.Language;
import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.service.WordService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordController {

    private final WordService wordService;
    private static final Logger LOGGER = LoggerFactory.logger(WordController.class);

    private final WordMapper mapper = Mappers.getMapper(WordMapper.class);

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // /words?word=test&language=ENG
    // /words?word=test&language=EST
    @GetMapping
    public List<WordDto> getWords(@RequestParam String word, @RequestParam(defaultValue = "EST") Language language){
        LOGGER.debug("Incoming GET for word: " + word + " in language " + language.toString());
        List<Word> bla = wordService.findFuzzyMatches(word, language);
        return mapper.wordsToDto(bla);
    }

    @PostMapping
    public WordDto saveWord(@RequestBody Word word){
        LOGGER.debug("Incoming POST with word: " + word.toString());
        return mapper.wordToWordDto(wordService.saveWord(word));
    }
}
