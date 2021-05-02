package com.vocabulary.vocabularybackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class WordDto {
    private Long Id;

    @Size(max = 50)
    private String wordInEstonian;

    @Size(max = 200)
    private String wordDefinitionInEstonian;

    @Size(max = 50)
    private String wordInEnglish;

    @Size(max = 200)
    private String wordDefinitionInEnglish;
}
