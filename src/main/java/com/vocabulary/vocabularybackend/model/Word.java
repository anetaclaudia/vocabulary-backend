package com.vocabulary.vocabularybackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Word(String wordInEstonian, String wordDefinitionInEstonian, String wordInEnglish, String wordDefinitionInEnglish) {
        this.wordInEstonian = wordInEstonian;
        this.wordDefinitionInEstonian = wordDefinitionInEstonian;
        this.wordInEnglish = wordInEnglish;
        this.wordDefinitionInEnglish = wordDefinitionInEnglish;
    }

    @Override
    public String toString() {
        return "wordInEstonian='" + wordInEstonian + '\'' +
                ", wordInEnglish='" + wordInEnglish;
    }


}
