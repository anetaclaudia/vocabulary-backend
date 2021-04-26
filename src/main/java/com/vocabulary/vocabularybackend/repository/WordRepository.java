package com.vocabulary.vocabularybackend.repository;

import com.vocabulary.vocabularybackend.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("select w from Word w where lower(w.wordInEstonian) = lower(:word)")
    List<Word> findExactMatchEstonian(@Param(value = "word") String word);

    @Query("select w from Word w where lower(w.wordDefinitionInEnglish) = lower(:word)")
    List<Word> findExactMatchEnglish(@Param(value = "word") String word);
}
