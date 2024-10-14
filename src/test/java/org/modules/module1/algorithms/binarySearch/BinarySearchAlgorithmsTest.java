package org.modules.module1.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
