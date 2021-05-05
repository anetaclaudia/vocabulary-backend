package com.vocabulary.vocabularybackend;

import com.vocabulary.vocabularybackend.controller.WordController;
import com.vocabulary.vocabularybackend.model.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

class WordControllerTests {

	@Autowired
	private WordController wordController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private static final ParameterizedTypeReference<List<Word>> LIST_OF_WORDS = new ParameterizedTypeReference<>() {
	};

	Word testWord = new Word(
			1L,
			"karu",
			"suur, karvane loom, kellele meeldib mesi",
			"bear",

			"big, hairy animal, who likes honey");

	@Test
	void testExample() {
		ResponseEntity<List<Word>> exchange = testRestTemplate.exchange(
				"/words",
				HttpMethod.GET,
				null,
				LIST_OF_WORDS);
		// exchange.getStatusCode();
		// exchange.getBody();
		// assert stuff
	}

	@Test
	void getWordsWithBothParamsSet(){

	}

	@Test
	void getWordsWithOnlyWordParamSet(){

	}

	@Test
	void saveWordWithAllFieldsSet(){
		Word wordToSave = new Word(
				"kass",
				"karvane, pisike loom",
				"cat",
				"hairy, small animal");
		ResponseEntity<Word> exchange = testRestTemplate.exchange(
				"/words",
				HttpMethod.POST,
				new HttpEntity<>(wordToSave),
				Word.class);
		Word word = assertOk(exchange);
		assertTrue(wordIsSame(word, wordToSave));
	}

	private boolean wordIsSame(Word word, Word word1){
		return word1.getWordInEstonian().equals(word.getWordInEstonian()) &&
				word1.getWordDefinitionInEstonian().equals(word.getWordDefinitionInEstonian()) &&
				word1.getWordInEnglish().equals(word.getWordInEnglish()) &&
				word1.getWordDefinitionInEnglish().equals(word.getWordDefinitionInEnglish());
	}

	private <T> T assertOk(ResponseEntity<T> exchange) {
		assertNotNull(exchange.getBody());
		assertEquals(HttpStatus.OK, exchange.getStatusCode());
		return exchange.getBody();
	}



}
