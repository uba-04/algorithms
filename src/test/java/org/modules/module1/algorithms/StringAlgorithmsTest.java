package org.modules.module1.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAlgorithmsTest {
  @Test
  void findIndexOfFirtsUniqueCharacter_WhenInputIsEmpty_ThenReturnMinusOne() {
    // Given
    String input = "";
    int expected = -1;

    // When
    int actual = StringAlgorithms.findIndexOfFirstUniqueCharacter(input);

    // Then
    assertEquals(expected, actual);
  }

  @Test
  void findIndexOfFirtsUniqueCharacter_WhenInputIsNull_ThenReturnMinusOne() {
    // Given
    String input = null;
    int expected = -1;

    // When
    int actual = StringAlgorithms.findIndexOfFirstUniqueCharacter(input);

    // Then
    assertEquals(expected, actual);
  }

  @Test
  void findIndexOfFirtsUniqueCharacter_WhenInputIsAValidString_ThenReturnIndexOfFirstUniqueCharacter() {
    // Given
    String input = "ceetcode";
    int expected = 3;

    // When
    int actual = StringAlgorithms.findIndexOfFirstUniqueCharacter(input);

    // Then
    assertEquals(expected, actual);
  }

  @Test
  void findIndexOfFirtsUniqueCharacter_WhenInputIsAValidStringWithNoUniqueCharacter_ThenReturnMinusOne() {
    // Given
    String input = "wordword";
    int expected = -1;

    // When
    int actual = StringAlgorithms.findIndexOfFirstUniqueCharacter(input);

    // Then
    assertEquals(expected, actual);
  }
}
