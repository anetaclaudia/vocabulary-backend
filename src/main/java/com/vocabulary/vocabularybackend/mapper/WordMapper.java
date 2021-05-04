package com.vocabulary.vocabularybackend.mapper;

import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.dto.WordDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {
    WordDto wordToWordDto(Word word);
    List<WordDto> wordsToDto(List<Word> words);
}
