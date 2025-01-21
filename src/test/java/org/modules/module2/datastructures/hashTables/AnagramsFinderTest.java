package org.modules.module2.datastructures.hashTables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramsFinderTest {

  private final AnagramsFinder anagramsFinder = new AnagramsFinder();

  @Test
  void find_returnsTrue_forSameWords() {
    // Given
    String firstWord = "hello";
    String secondWord = "loelh";

    // When
    boolean actualResult = anagramsFinder.find(firstWord, secondWord);

    // Then
    assertTrue(actualResult);
  }

  @Test
  void find_returnsFalse_forDifferentLengthWords() {
    // Given
    String firstWord = "hello";
    String secondWord = "hey";

    // When
    boolean actualResult = anagramsFinder.find(firstWord, secondWord);

    // Then
    assertFalse(actualResult);
  }

  @Test
  void find_returnsFalse_forDifferentWords() {
    // Given
    String firstWord = "hello";
    String secondWord = "loell";

    // When
    boolean actualResult = anagramsFinder.find(firstWord, secondWord);

    // Then
    assertFalse(actualResult);
  }
}
