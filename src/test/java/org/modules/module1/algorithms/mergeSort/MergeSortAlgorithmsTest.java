package org.modules.module1.algorithms.mergeSort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modules.module1.datastructures.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeSortAlgorithmsTest {

  private static MergeSortAlgorithms mergeSortAlgorithms;

  @BeforeAll
  static void setUp() {
    mergeSortAlgorithms = new MergeSortAlgorithms();
  }

  @Test
  void mergeSort_sortsArraySuccessfully() {
    // Given
    int[] array = { 12, 11, 13, 5, 6, 7 };

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

    // When
    mergeSortAlgorithms.mergeSort(array, 0, array.length - 1);

    // Then
    int[] expectedArray = { 1 };
    assertArrayEquals(expectedArray, array);
  }

  @Test
  void sortList_returnsNull_whenHeadIsNull() {
    // Given and when
    ListNode result = mergeSortAlgorithms.sortList(null);

    // Then
    assertNull(result);
  }

  @Test
  void sortList_returnsHead_whenHeadNextIsNull() {
    // Given
    ListNode head = new ListNode(1);

    // When
    ListNode result = mergeSortAlgorithms.sortList(head);

    // Then
    assertEquals(head, result);
  }

  @Test
  void sortList_sortsListSuccessfully() {
    // Given
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);

    // When
    ListNode result = mergeSortAlgorithms.sortList(head);

    // Then
    assertEquals(1, result.val);
    assertEquals(2, result.next.val);
    assertEquals(3, result.next.next.val);
    assertEquals(4, result.next.next.next.val);
  }

  @Test
  void sortStringArray_sortsArraySuccessfully() {
    // Given
    String[] array = { "kiwi", "orange", "banana", "apple", "grape" };

    // When
    mergeSortAlgorithms.sortStringArray(array, 0, array.length - 1);

    // Then
    String[] expectedArray = { "apple", "banana", "grape", "kiwi", "orange" };
    assertArrayEquals(expectedArray, array);
  }

  @Test
  void mergeSortList_sortsListSuccessfully() {
    // Given
    List<Double> list = new ArrayList<>();
    list.add(4.0);
    list.add(2.0);
    list.add(1.0);
    list.add(3.0);
    list.add(5.5);
    List<Double> expectedList = new ArrayList<>();
    expectedList.add(1.0);
    expectedList.add(2.0);
    expectedList.add(3.0);
    expectedList.add(4.0);
    expectedList.add(5.5);

    // When
    mergeSortAlgorithms.mergeSortList(list);

    // Then
    assertEquals(expectedList, list);
  }
}
