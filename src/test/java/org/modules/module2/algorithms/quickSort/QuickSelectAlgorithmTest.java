package org.modules.module2.algorithms.quickSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuickSelectAlgorithmTest {

  private final QuickSelectAlgorithm quickSelectAlgorithm = new QuickSelectAlgorithm();

  @Test
  void findKthSmallest_throwsIllegalArgumentException_whenKIsLessThanOne() {
    // Given
    int[] array = { 1, 2, 3, 4, 5 };
    int k = 0;

    // When and Then
    assertThrows(IllegalArgumentException.class, () -> quickSelectAlgorithm.findKthSmallest(array, k));
  }

  @Test
  void findKthSmallest_throwsIllegalArgumentException_whenKIsGreaterThanArrayLength() {
    // Given
    int[] array = { 1, 2, 3, 4, 5 };
    int k = 6;

    // When and Then
    assertThrows(IllegalArgumentException.class, () -> quickSelectAlgorithm.findKthSmallest(array, k));
  }

  @Test
  void findKthSmallest_returnsKthSmallestElement_whenKIsValid() {
    // Given
    int[] array = { 5, 2, 8, 3, 0, 1 };
    int k = 3;
    int expected = 2;

    // When
    int result = quickSelectAlgorithm.findKthSmallest(array, k);

    // Then
    assertEquals(expected, result);
  }

  @Test
  void findKthSmallest_returnsKthSmallestElement_whenKIsValid2() {
    // Given
    int[] array = { 5, 2, 8, 3, 0, 1 };
    int k = 1;
    int expected = 0;

    // When
    int result = quickSelectAlgorithm.findKthSmallest(array, k);

    // Then
    assertEquals(expected, result);
  }
}
