package org.modules.module2.algorithms.quickSort;

public class QuickSortAlgorithms {
  public void sort(int[] array, int lowIndex, int highIndex) {
    if(lowIndex < highIndex) {
      int pivotIndex = partition(array, lowIndex, highIndex);
      sort(array, lowIndex, pivotIndex - 1);
      sort(array, pivotIndex + 1, highIndex);
    }
  }

  public void sort(String[] array, int lowIndex, int highIndex) {
    if(lowIndex < highIndex) {
      int pivotIndex = partition(array, lowIndex, highIndex);
      sort(array, lowIndex, pivotIndex - 1);
      sort(array, pivotIndex + 1, highIndex);
    }
  }

  private int partition(int[] array, int lowIndex, int highIndex) {
    int pivot = array[highIndex];
    int i = lowIndex - 1;

    for(int j = lowIndex; j < highIndex; j++) {
      if(array[j] <= pivot) {
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

  private int partition(String[] array, int lowIndex, int highIndex) {
    String pivot = array[highIndex];
    int i = lowIndex - 1;

    for(int j = lowIndex; j < highIndex; j++) {
      if(array[j].compareTo(pivot) <= 0) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, highIndex);
    return i + 1;
  }

  private void swap(String[] array, int index, int newIndex) {
    String temp = array[index];
    array[index] = array[newIndex];
    array[newIndex] = temp;
  }
}
