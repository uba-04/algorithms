package org.modules.module1.datastructures.linkedList;

public class Palindrome {

  public boolean isPalindrome(ListNode list) {
    int number = list.val;
    int reverseNumber = list.val;
    int multiplier = 10;
    while(list.next != null) {
      number = (number * 10) + list.next.val;
      reverseNumber = reverseNumber + (list.next.val * multiplier);
      list = list.next;
      multiplier *= 10;
    }
    return number == reverseNumber;
  }
}
