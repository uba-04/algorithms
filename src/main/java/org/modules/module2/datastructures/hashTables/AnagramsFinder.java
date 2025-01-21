package org.modules.module2.datastructures.hashTables;

import java.util.HashMap;
import java.util.Map;

public class AnagramsFinder {
//  Verify if two strings are anagrams: Two words are anagrams if they contain the same letters
//  in a different order. Check if two strings are anagrams using a hash table.
  public boolean find(String firstWord, String secondWord) {
    if(firstWord.length() != secondWord.length()) {
      return false;
    }
    Map<Character, Integer> firstCharsFrequency = getCharactersFrequency(firstWord);
    Map<Character, Integer> secondCharsFrequency = getCharactersFrequency(secondWord);
    return firstCharsFrequency.equals(secondCharsFrequency);
  }

  private Map<Character, Integer> getCharactersFrequency(String word) {
    var charsFrequency = new HashMap<Character, Integer>();
    for (Character character : word.toCharArray()) {
      charsFrequency.put(character, charsFrequency.getOrDefault(character, 0) + 1);
    }
    return charsFrequency;
  }
}
