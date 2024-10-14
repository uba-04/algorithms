package org.modules.module2.datastructures.stackAndQueues;

import java.util.Stack;

public class TowerOfHanoi {
  public void solveTowerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
    Stack<Integer> sourceStack = new Stack<>();
    Stack<Integer> auxiliaryStack = new Stack<>();
    Stack<Integer> destinationStack = new Stack<>();

    // Push disks onto the source stack in descending order
    for (int i = numDisks; i > 0; i--) {
      sourceStack.push(i);
    }

    moveDisks(numDisks, sourceStack, auxiliaryStack, destinationStack, source, auxiliary, destination);
  }

  public void moveDisks(int numDisks, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> destination,
                               char sourceName, char auxiliaryName, char destinationName) {
    if (numDisks > 0) {
      // Move numDisks-1 disks from source to auxiliary using destination as the temporary peg
      moveDisks(numDisks - 1, source, destination, auxiliary, sourceName, destinationName, auxiliaryName);

      // Move the largest disk from source to destination
      int disk = source.pop();
      destination.push(disk);
      System.out.println("Move disk " + disk + " from " + sourceName + " to " + destinationName);

      // Move the remaining numDisks-1 disks from auxiliary to destination using source as the temporary peg
      moveDisks(numDisks - 1, auxiliary, source, destination, auxiliaryName, sourceName, destinationName);
    }
  }
}
