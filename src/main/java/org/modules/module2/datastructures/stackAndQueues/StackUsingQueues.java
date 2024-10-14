package org.modules.module2.datastructures.stackAndQueues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
  private Queue<T> queue1;
  private Queue<T> queue2;

  public StackUsingQueues() {
    this.queue1 = new LinkedList<>();
    this.queue2 = new LinkedList<>();
  }

  public boolean push(T element) {
    return queue1.add(element);
  }

  public T pop() {
    if(queue1.isEmpty()) {
      throw new IllegalStateException("Stack is empty.");
    }

    while(queue1.size() > 1) {
      queue2.add(queue1.poll());
    }
    T element = queue1.poll();
    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return element;
  }

  public T top() {
    if(queue1.isEmpty()) {
      throw new IllegalStateException("Stack is empty.");
    }

    while(queue1.size() > 1) {
      queue2.add(queue1.poll());
    }
    T element = queue1.peek();
    queue2.add(queue1.poll());
    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;

    return element;
  }

  public int size() {
    return queue1.size();
  }

  public boolean isEmpty() {
    return queue1.isEmpty();
  }
}
