package com.vocabulary.vocabularybackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Word {

    @Id @GeneratedValue private Long id;
    private String wordInEstonian;
    private String wordDefinitionInEstonian;
    private String wordInEnglish;
    private String wordDefinitionInEnglish;


}
