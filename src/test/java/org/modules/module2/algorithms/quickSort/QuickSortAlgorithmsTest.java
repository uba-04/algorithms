package org.modules.module2.algorithms.quickSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortAlgorithmsTest {

  private final QuickSortAlgorithms sortAlgorithms = new QuickSortAlgorithms();

  @Test
  void sort_sortsIntArraySuccessfully() {
    // Given
    int[] array = new int[]{5,6,2,9,10,2,4,3};
    int[] expectedArray = new int[]{2,2,3,4,5,6,9,10};

    // When
    sortAlgorithms.sort(array, 0, array.length - 1);

    // Then
    assertArrayEquals(expectedArray, array);
  }

  @Test
  void sort_sortsStringArraySuccessfully() {
    // Given
    String[] array = new String[]{"hello", "word", "name", "lastName", "location"};
    String[] expectedArray = new String[]{"hello", "lastName", "location", "name", "word"};

    // When
    sortAlgorithms.sort(array, 0, array.length - 1);

    // Then
    assertArrayEquals(expectedArray, array);
  }
}
