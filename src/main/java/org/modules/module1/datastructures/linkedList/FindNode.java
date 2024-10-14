package org.modules.module1.datastructures.linkedList;

public class FindNode {
  // Finding the k-th node from the end of a linked list
  public ListNode findNode(ListNode list, int nodeNumber) {
    int length = getListLength(list);
    if(nodeNumber > length || nodeNumber < 1) {
      throw new IndexOutOfBoundsException("The node number to be found should not exceed the " +
            "list size and cannot be less than 1.");
    }
    int nodeIndex = length - nodeNumber + 1;
    int index = 1;
    while(list != null) {
      if(nodeIndex == index) {
        return list;
      }
      index++;
      list = list.next;
    }
    throw new RuntimeException("Node could not be found.");
  }

  private int getListLength(ListNode list) {
    int length = 0;
    while(list != null) {
      length++;
      list = list.next;
    }
    return length;
  }
}
