package org.modules.module1.datastructures.linkedList;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseLinkedListTest {

  @Test
  void reverseLinkedList_returnsEmptyList_whenEmptyListIsPassed() {
    // Arrange
    var list = new LinkedList<Integer>();
    var reverseLinkedList = new ReverseLinkedList<>(list);

    // Act
    LinkedList<Integer> reversedList = reverseLinkedList.reverseLinkedList();

    // Assert
    assertTrue(reversedList.isEmpty());
  }

  @Test
  void reverseLinkedList_returnsReversedList() {
    // Arrange
    var list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    var reverseLinkedList = new ReverseLinkedList<>(list);
    var expectedList = new LinkedList<Integer>();
    expectedList.add(3);
    expectedList.add(2);
    expectedList.add(1);

    // Act
    LinkedList<Integer> reversedList = reverseLinkedList.reverseLinkedList();

    // Assert
    assertEquals(expectedList, reversedList);
  }
}
