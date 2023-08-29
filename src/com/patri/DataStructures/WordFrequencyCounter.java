package com.patri.DataStructures;

import java.util.HashMap;

public class WordFrequencyCounter {

    public static HashMap<String, Integer> getCounterForEachWord(String sentence) {

        HashMap<String, Integer> outputMap = new HashMap<>();

        if (sentence != null) {
            String[] words = sentence.split(" ");


            for (String word : words) {
                // we want only word (if we have 2 spaces -> using split we will get an empty string: "")
                // starting with Java 11 - we can use .isBlank() method to test for all the whitespaces
                if (!word.isEmpty()) {

                    // we take the first word and we check if it's part of the map already

                    // if it's not in the map (that key does not exist) we add the new entry (key, value) to the map
                    if (!outputMap.containsKey(word)) {
                        outputMap.put(word, 1);
                    }
                    // if it's already in the map (that key exists) we increase the value for that key
                    else {
                        outputMap.put(word, outputMap.get(word) + 1);
                    }
                }
            }
        }

        return outputMap;
    }

    public static boolean isCharacterAlphanumeric(char character){
        // we check if the character is number or Uppercase letter, lowercase letter
        return ((int) character >= 48 && (int) character <= 57) ||
                ((int) character >= 65 && (int) character <= 90) ||
                ((int) character >= 97 && (int) character <= 122);
    }

    public static HashMap<String, Integer> getCounterForEachWordV2(String sentence) {

        HashMap<String, Integer> outputMap = new HashMap<>();

        if (sentence != null) {
            String[] words = sentence.split(" ");


            for (String word : words) {
                // we want only word (if we have 2 spaces -> using split we will get an empty string: "")
                // starting with Java 11 - we can use .isBlank() method to test for all the whitespaces
                if (!word.isEmpty()) {

                    // we take the word and we see if it contains non-alphanumeric characters
                    // if it contains characters we split the word into the right words and we add them to the map

                    StringBuilder newWord = new StringBuilder();
                    for (int i = 0; i < word.length(); i++) {
                        if (isCharacterAlphanumeric(word.charAt(i))) {
                            newWord.append(word.charAt(i));
                        } else {
                            // here we have the new word

                            // if it's not in the map (that key does not exist) we add the new entry (key, value) to the map
                            insertOrUpdateWord(outputMap, newWord.toString());
                            newWord.delete(0, newWord.length());
                        }
                    }

                    // we finished working with the word and we need to add it to the map
                    insertOrUpdateWord(outputMap, newWord.toString());
                }
            }
        }

        return outputMap;
    }

    private static void insertOrUpdateWord(HashMap<String, Integer> outputMap, String newWord) {
        // if it's not in the map (that key does not exist) we add the new entry (key, value) to the map
        if (!outputMap.containsKey(newWord)) {
            outputMap.put(newWord, 1);
        }
        // if it's already in the map (that key exists) we increase the value for that key
        else {
            outputMap.put(newWord, outputMap.get(newWord) + 1);
        }
    }

    public static void main(String[] args) {
        String sentence = "This is the  best string that is the best of the best best";
        String sentenceWithWhitespace = "This is the  best \t string that is the \n best of \r the best best";
        String sentenceNull = null;
        System.out.println(getCounterForEachWord(sentence));
        System.out.println(getCounterForEachWord(sentenceNull));
        System.out.println(getCounterForEachWord(sentenceWithWhitespace));

        String sentenceV2 = "This  is the.best string there is";
        System.out.println(getCounterForEachWordV2(sentenceV2));
    }
}
