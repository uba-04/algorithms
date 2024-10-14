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
    Map<Character, Integer> charactersFrequency = new HashMap<>();
    for(int i = 0; i < firstWord.length(); i++) {
      charactersFrequency.put(
            firstWord.charAt(i), charactersFrequency.getOrDefault(firstWord.charAt(i), 0) + 1);
    }
    for(int i = 0; i < secondWord.length(); i++) {
      if(charactersFrequency.get(secondWord.charAt(i)) == null) {
        return false;
      }
    }
    return true;
  }
}
