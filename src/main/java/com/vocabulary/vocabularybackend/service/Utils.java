package com.vocabulary.vocabularybackend.service;

import com.vocabulary.vocabularybackend.model.Language;
import com.vocabulary.vocabularybackend.model.Word;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {
    private static final int MAX_DIFFERENCES = 2;

    // https://www.baeldung.com/java-levenshtein-distance
    static int computeLevenshteinDistance(String word, String wordFromDb) {
        int[][] result = new int[word.length() + 1][wordFromDb.length() + 1];

        for (int i = 0; i <= word.length(); i++) {
            for (int j = 0; j <= wordFromDb.length(); j++) {

                if (i == 0) {
                    result[i][j] = j;
                } else if (j == 0) {
                    result[i][j] = i;
                } else {
                    result[i][j] = minimumEdits(result[i - 1][j - 1]
                                    + NumOfReplacement(word.charAt(i - 1), wordFromDb.charAt(j - 1)), // replace
                            result[i - 1][j] + 1, // delete
                            result[i][j - 1] + 1); // insert
                }
            }
        }

        return result[word.length()][wordFromDb.length()];
    }

    static int NumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    static int minimumEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(
                Integer.MAX_VALUE);
    }

    static List<Word> getFuzzyWords(String input, List<Word> words, Language language) {
        Map<Word, Integer> resultWithDifferences = new HashMap<>();
        for (Word word : words) {
            String wordInLanguage = "";
            if (language == Language.ENG) {
                wordInLanguage = word.getWordInEnglish();
            } else {
                wordInLanguage = word.getWordInEstonian();
            }
            if (computeLevenshteinDistance(input, wordInLanguage) <= MAX_DIFFERENCES
                    && !resultWithDifferences.containsKey(word)) {
                int value = computeLevenshteinDistance(input, wordInLanguage);
                resultWithDifferences.put(word, value);
            }
        }

        Map<Word, Integer> sortedMap = sortMapAscendingOrder(resultWithDifferences);

        return new ArrayList<>(sortedMap.keySet());
    }

    static Map<Word, Integer> sortMapAscendingOrder(Map<Word, Integer> input) {
        return input.entrySet()
                .stream()
                .sorted(Map.Entry.<Word, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
