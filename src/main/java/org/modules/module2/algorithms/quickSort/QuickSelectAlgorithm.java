package org.modules.module2.algorithms.quickSort;

public class QuickSelectAlgorithm {
  public int findKthSmallest(int[] array, int k) {
    if(k < 1 || k > array.length) {
      throw new IllegalArgumentException("Invalid value of 'k'.");
    }
    return quickSelect(array, k - 1, 0, array.length - 1);
  }

  private int quickSelect(int[] array, int k, int lowIndex, int highIndex) {
    if(lowIndex == highIndex) {
      return array[lowIndex];
    }
    int pivotIndex = partition(array, lowIndex, highIndex);
    if(pivotIndex == k) {
      return array[pivotIndex];
    } else if(pivotIndex > k) {
      return quickSelect(array, k, lowIndex, pivotIndex - 1);
    } else {
      return quickSelect(array, k, pivotIndex + 1, highIndex);
    }
  }

  private int partition(int[] array, int lowIndex, int highIndex) {
    int pivot = array[highIndex];
    int i = lowIndex - 1;
    for(int j = lowIndex; j < highIndex; j++) {
      if(array[j] < pivot) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, highIndex);
    return i + 1;
  }

  private void swap(int[] array, int index, int newIndex) {
    int temp = array[index];
    array[index] = array[newIndex];
    array[newIndex] = temp;
  }
}
