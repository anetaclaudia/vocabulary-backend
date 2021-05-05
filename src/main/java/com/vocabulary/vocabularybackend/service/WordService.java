package com.vocabulary.vocabularybackend.service;

import com.vocabulary.vocabularybackend.model.Language;
import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    // replacing 1-2 letters in the search keyword should still yield relevant results
    // possible solution levenshtein distance
    // https://www.baeldung.com/java-levenshtein-distance
    public List<Word> findFuzzyMatches(String word, Language language) {
        List<Word> resultFromRepository = new ArrayList<>();
        if (language == Language.EST) {
            resultFromRepository.addAll(wordRepository.findFuzzyMatchesEstonian(word));
        } else if (language == Language.ENG) {
            resultFromRepository.addAll(wordRepository.findFuzzyMatchesEnglish(word));
        }

        return Utils.getFuzzyWords(word, resultFromRepository, language);
    }

    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }
}
