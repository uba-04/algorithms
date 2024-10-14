package org.modules.module1.algorithms.binarySearch;

public class BinarySearchAlgorithms {

  // Find an element in a sorted array
  public int findElement(int[] array, int value) {
    int leftIndex = 0;
    int rightIndex = array.length - 1;
    return findElement(array, value, leftIndex, rightIndex);
  }

  private int findElement(int[] array, int value, int leftIndex, int rightIndex) {
    int index = leftIndex + (rightIndex - leftIndex) / 2;
    if(array[index] == value) {
      return index;
    }
    if(leftIndex >= rightIndex) {
      return -1;
    }
    else if(value < array[index]) {
      return findElement(array, value, leftIndex, index - 1);
    }
    else {
      return findElement(array, value, index + 1, rightIndex);
    }
  }

  public double getSquareRoot(double number) {
    if(number < 0) {
      throw new IllegalArgumentException("Only positive numbers are allowed.");
    }
    if(number == 0) {
      return 0;
    }
    double start;
    double end;
    if(number < 1) {
      start = 0;
      end = 1;
    } else {
      start = 1;
      end = number;
    }
    double epsilon = 0.00001;
    while(end - start > epsilon) {
      double mid = (start + end) / 2;
      if(Math.abs(mid * mid - number) < epsilon) {
        return getFourDecimalsNumber(mid);
      } else if(mid * mid > number) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return getFourDecimalsNumber((start + end) / 2);
  }

  public double getFourDecimalsNumber(double number) {
    return ((int) (number * 10000)) / 10000.0;
  }

// [7, 8, 9, 1, 2, 3, 4, 5, 6]
  public int findRotationPoint(int[] array) {
    int leftIndex = 0;
    int rightIndex = array.length - 1;

    while(leftIndex < rightIndex) {
      int mid = leftIndex + (rightIndex - leftIndex) / 2;

      if(mid > 0 && array[mid] < array[mid - 1]) {
        return mid;
      } else if (array[mid] >= array[leftIndex]) {
        leftIndex = mid + 1;
      } else {
        rightIndex = mid - 1;
      }
    }
    return leftIndex;
  }
}
