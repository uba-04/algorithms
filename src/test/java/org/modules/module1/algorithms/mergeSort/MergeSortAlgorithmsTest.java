package org.modules.module1.algorithms.mergeSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortAlgorithmsTest {

  @Test
  void mergeSort_sortsArraySuccessfully() {
    // Given
    int[] array = { 12, 11, 13, 5, 6, 7 };
    MergeSortAlgorithms mergeSortAlgorithms = new MergeSortAlgorithms();

    // When
    mergeSortAlgorithms.mergeSort(array, 0, array.length - 1);

    // Then
    int[] expectedArray = { 5, 6, 7, 11, 12, 13 };
    assertArrayEquals(expectedArray, array);
  }

  @Test
  void mergeSort_sortsArraySuccessfully2() {
    // Given
    int[] array = { 38, 27, 43, 3, 9, 82, 10 };
    MergeSortAlgorithms mergeSortAlgorithms = new MergeSortAlgorithms();

    // When
    mergeSortAlgorithms.mergeSort(array, 0, array.length - 1);

    // Then
    int[] expectedArray = { 3, 9, 10, 27, 38, 43, 82 };
    assertArrayEquals(expectedArray, array);
  }

  @Test
  void mergeSort_doesNotSortArray_whenLengthEqualsOne() {
    // Given
    int[] array = { 1 };
    MergeSortAlgorithms mergeSortAlgorithms = new MergeSortAlgorithms();

    // When
    mergeSortAlgorithms.mergeSort(array, 0, array.length - 1);

    // Then
    int[] expectedArray = { 1 };
    assertArrayEquals(expectedArray, array);
  }
}
