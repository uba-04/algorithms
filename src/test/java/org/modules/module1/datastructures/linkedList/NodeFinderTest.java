package org.modules.module1.datastructures.linkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeFinderTest {

  private static NodeFinder nodeFinder;

  @BeforeAll
  static void setUp() {
    nodeFinder = new NodeFinder();
  }

  @Test
  void findNode_throwsIndexOutOfBoundsException_whenNodeNumberIsLessThanOne() {
    // Given
    ListNode list = new ListNode(1);
    int nodeNumber = 0;

    // When and then
    assertThrows(IndexOutOfBoundsException.class, () -> nodeFinder.findNode(list, nodeNumber));
  }

  @Test
  void findNode_throwsIndexOutOfBoundsException_whenNodeNumberIsGreaterThanListSize() {
    // Given
    ListNode list = new ListNode(1);
    int nodeNumber = 2;

    // When and then
    assertThrows(IndexOutOfBoundsException.class, () -> nodeFinder.findNode(list, nodeNumber));
  }

  @Test
  void findNode_returnsCorrectNode() {
    // Given
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    int nodeNumber = 2;

    // When
    ListNode result = nodeFinder.findNode(list, nodeNumber);

    // Then
    assertEquals(2, result.val);
  }
}
