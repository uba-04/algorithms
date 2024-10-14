package org.modules.module1.algorithms;

public class StringAlgorithms {
  public int findIndexOfFirstUniqueCharacter(String input) {
    if (input == null || input.isEmpty()) {
      return -1;
    }
    int[] charactersCount = new int[26];
    for (int i = 0; i < input.length(); i++) {
      charactersCount[input.charAt(i) - 'a']++;
    }
    for(int i = 0; i < input.length(); i++) {
      if(charactersCount[input.charAt(i) -  'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
