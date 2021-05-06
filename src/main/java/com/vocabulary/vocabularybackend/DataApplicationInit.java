package com.vocabulary.vocabularybackend;

import com.vocabulary.vocabularybackend.model.Word;
import com.vocabulary.vocabularybackend.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataApplicationInit implements CommandLineRunner {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        Word tulp = new Word(1L,
                "tulp",
                "lill",
                "tulip", // length 6
                "flower");
        Word tulp1 = new Word(2L,
                "tulp",
                "veerg",
                "column", // length 6
                "a thing in excel");
        Word palk = new Word(3L,
                "palk",
                "töötasu",
                "salary", // length 6
                "payment for work");
        Word palk1 = new Word(4L,
                "palk",
                "puidust materjal",
                "log", // length 3
                "material out of wood, also known as log");
        Word kulp = new Word(5L,
                "kulp",
                "tarvik, mida kasutatakse köögis",
                "ladle", // length 5
                "tool, which is commonly used in kitchen");
        Word tulu = new Word(6L,
                "tulu",
                "sissetulek, kasum",
                "profit", // length 6
                "income");
        Word pilvelohkuja = new Word(7L,
                "pilvelohkuja",
                "korge ehitis",
                "skyscraper", // length 9
                "tall building");
        Word tuli = new Word(8L,
                "tuli",
                "asi, mis põleb leegitsedes",
                "fire",
                "thing that burns");
        Word turg = new Word(9L,
                "turg",
                "koht, kus saab kaubelda",
                "marketplace",
                "place, where people are selling things");


        wordRepository.save(tulp);
        wordRepository.save(tulp1);
        wordRepository.save(palk);
        wordRepository.save(palk1);
        wordRepository.save(kulp);
        wordRepository.save(tulu);
        wordRepository.save(pilvelohkuja);
        wordRepository.save(tuli); // tulp - tuli - 1
        wordRepository.save(turg); // tulp - turg - 2
    }
}
