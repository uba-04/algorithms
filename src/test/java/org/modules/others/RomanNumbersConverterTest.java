package org.modules.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumbersConverterTest {
  @Test
  void fromIntToRoman_returnsCorrectString() {
    // Given
    int number = 2024;
    String expected = "MMXXIV";
    // When
    String result = RomanNumbersConverter.fromIntToRoman(number);
    // Then
    assertEquals(expected, result);
  }

  @Test
  void fromIntToRoman_returnsCorrectString2() {
    // Given
    int number = 1996;
    String expected = "MCMXCVI";
    // When
    String result = RomanNumbersConverter.fromIntToRoman(number);
    // Then
    assertEquals(expected, result);
  }

  @Test
  void fromIntToRoman_returnsCorrectString3() {
    // Given
    int number = 3999;
    String expected = "MMMCMXCIX";
    // When
    String result = RomanNumbersConverter.fromIntToRoman(number);
    // Then
    assertEquals(expected, result);
  }

  @Test
  void fromIntToRoman_returnsCorrectString4() {
    // Given
    int number = 2500;
    String expected = "MMD";
    // When
    String result = RomanNumbersConverter.fromIntToRoman(number);
    // Then
    assertEquals(expected, result);
  }
}
