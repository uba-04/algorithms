package org.modules.module1.datastructures.linkedList;

import java.util.LinkedList;

public class ReverseLinkedList<E> {
  private LinkedList<E> list;

  public ReverseLinkedList(LinkedList<E> list) {
    this.list = list;
  }

  public LinkedList<E> reverseLinkedList() {
    LinkedList<E> newList = new LinkedList<E>();
    while(!list.isEmpty()) {
      newList.addFirst(list.poll());
    }
    return newList;
  }
}
