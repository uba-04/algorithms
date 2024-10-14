package org.modules.module2.datastructures.stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks<T> {
  private Stack<T> stack1;
  private Stack<T> stack2;

  public QueueUsingStacks() {
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }

  public boolean add(T element) {
    if(stack1.push(element) != null) {
      return true;
    }
    throw new IllegalStateException("No space available in the Queue.");
  }

  public T peek() {
    if(stack1.isEmpty()) {
      throw new IllegalStateException("Queue is empty.");
    }
    while(stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    T element = stack1.peek();
    while(!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
    return element;
  }

  public T poll() {
    if(stack1.isEmpty()) {
      throw new IllegalStateException("Queue is empty.");
    }
    while(stack1.size() > 1) {
      stack2.push(stack1.pop());
    }
    T element = stack1.pop();
    while(!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
    return element;
  }

  public int size() {
    return stack1.size();
  }

  public boolean isEmpty() {
    return stack1.isEmpty();
  }
}
