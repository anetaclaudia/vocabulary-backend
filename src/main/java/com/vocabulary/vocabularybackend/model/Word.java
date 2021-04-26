package com.vocabulary.vocabularybackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Word {

    @Id @GeneratedValue
    private Long id;

    @Size(max = 50)
    private String wordInEstonian;

    @Size(max = 200)
    private String wordDefinitionInEstonian;

    @Size(max = 50)
    private String wordInEnglish;

    @Size(max = 200)
    private String wordDefinitionInEnglish;


}
