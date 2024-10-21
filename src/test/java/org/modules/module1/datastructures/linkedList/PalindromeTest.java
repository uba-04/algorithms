package org.modules.module1.datastructures.linkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
  private static Palindrome palindrome;

  @BeforeAll
  static void setup() {
    palindrome = new Palindrome();
  }

  @Test
  void isPalindrome_returnsTrue_whenListIsPalindrome() {
    // Given
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);

    // When
    boolean result = palindrome.isPalindrome(head);

    // Then
    assertTrue(result);
  }

  @Test
  void isPalindrome_returnsFalse_whenListIsNotPalindrome() {
    // Given
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);

    // When
    boolean result = palindrome.isPalindrome(head);

    // Then
    assertFalse(result);
  }
}
