package org.modules.module2.datastructures.hashTables;

import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
  public Map countWords(String text) {
    String[] words = text.split("\\s+");
    Map<String, Integer> wordCounter = new HashMap<>();

    for(String word : words) {
      wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
    }

    return wordCounter;
  }
}
