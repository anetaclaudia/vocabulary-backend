package com.vocabulary.vocabularybackend.service;

import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> findExactMatchesInEstonian(String word){
        return wordRepository.findExactMatchEstonian(word);
    }

    public List<Word> findExactMatchesInEnglish(String word){
        return wordRepository.findExactMatchEnglish(word);
    }

    // replacing 1-2 letters in the search keyword should still yield relevant results
    // possible solution levenshtein distance
    // https://www.baeldung.com/java-levenshtein-distance
    public List<Word> findFuzzyMatchesEstonian(String word){
        return null;
    }

    public List<Word> findFuzzyMatchesEnglish(String word){
        return null;
    }

    public List<Word> findFuzzyMatches(){
        return null;
    }

    public Word saveNewWord(Word word){
        return null;
    }

    public Word addNewDefinitionsForWord(Word word){
        return null;
    }
}
