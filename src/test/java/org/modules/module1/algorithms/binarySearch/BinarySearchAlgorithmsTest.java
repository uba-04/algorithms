package org.modules.module1.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchAlgorithmsTest {

  @Test
  void findElement_returnsCorrectIndex() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    for(int i = 0; i < array.length; i++) {
      // When
      int actual = binarySearchAlgorithms.findElement(array, array[i]);
      // Then
      assertEquals(i, actual);
    }
  }

  @Test
  void findElement_returnsCorrectIndex_whenValueIsNotInArray() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int value = 10;
    int expected = -1;
    // When
    int actual = binarySearchAlgorithms.findElement(array, value);
    // Then
    assertEquals(expected, actual);
  }

  @Test
  void getSquareRoot_returnsCorrectValue() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    double number = 0.13;
    // When
    for(double i = number; i <= 20; i = i + 0.1) {
      double expected = binarySearchAlgorithms.getFourDecimalsNumber(Math.sqrt(i));
      double actual = binarySearchAlgorithms.getSquareRoot(i);
      // Then
      assertEquals(expected, actual);
    }
  }

  @Test
  void getSquareRoot_returnsCorrectValue_whenNumberIsZero() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    double number = 0;
    double expected = 0;
    // When
    double actual = binarySearchAlgorithms.getSquareRoot(number);
    // Then
    assertEquals(expected, actual);
  }

  @Test
  void getSquareRoot_throwsIllegalArgumentException_whenNumberIsNegative() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    double number = -17.53;
    assertThrows(IllegalArgumentException.class, () -> binarySearchAlgorithms.getSquareRoot(number));
  }

  @Test
  void findRotationPoint_returnsCorrectIndex() {
    // Given
    BinarySearchAlgorithms binarySearchAlgorithms = new BinarySearchAlgorithms();
    int[] array = {7, 8, 9, 1, 2, 3, 4, 5, 6};
    int expected = 3;
    // When
    int actual = binarySearchAlgorithms.findRotationPoint(array);
    // Then
    assertEquals(expected, actual);
  }
}
