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
        return wordRepository.findWordExactMatchEstonian(word);
    }

    public List<Word> findExactMatchesInEnglish(String word){
        return wordRepository.findWordExactMatchEnglish(word);
    }

    // replacing 1-2 letters in the search keyword should still yield relevant results
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
