package org.modules.others;

import java.text.DecimalFormat;
import java.util.*;

public class FindRunningMedian {
  private static Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  private static Queue<Integer> minHeap = new PriorityQueue<>();

  /*
    * Solution using heaps
   */
  public static List<Double> runningMedian(List<Integer> list) {
    List<Double> medians = new ArrayList<>();
    for (Integer number : list) {
      addNumberToAHeap(number);
      double median = getMedian();
      medians.add(median);
      System.out.println(median);
    }
    return medians;
  }

  private static void addNumberToAHeap(Integer number) {
    if(maxHeap.isEmpty() && minHeap.isEmpty()) {
      minHeap.add(number);
    } else if(heapsLengthsAreSame()) {
      if(number <= maxHeap.peek()) maxHeap.add(number);
      else minHeap.add(number);
    } else if(minHeapIsGreater()) {
      if(number >= minHeap.peek()) {
        maxHeap.add(minHeap.poll());
        minHeap.add(number);
      } else {
        maxHeap.add(number);
      }
    } else {
      if(number <= maxHeap.peek()) {
        minHeap.add(maxHeap.poll());
        maxHeap.add(number);
      } else {
        minHeap.add(number);
      }
    }
  }

  private static boolean heapsLengthsAreSame() {
    return !maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.size() == minHeap.size();
  }

  private static boolean minHeapIsGreater() {
    if(!minHeap.isEmpty()) {
      return maxHeap.isEmpty() || minHeap.size() > maxHeap.size();
    } else {
      return false;
    }
  }

  private static double getMedian() {
    if(heapsLengthsAreSame()) return (minHeap.peek().doubleValue() + maxHeap.peek().doubleValue()) / 2;
    else if(minHeapIsGreater()) return minHeap.peek();
    else return maxHeap.peek();
  }

  /*
    * Solution by brute force
   */
  public static List<Double> runningMedian2(List<Integer> list) {
     List<Double> sortedList = new ArrayList<>();
     List<Double> medianValues = new ArrayList<>();
     for(Integer number : list) {
         sortedList.add(Double.valueOf(number));
         sort(sortedList, 0, sortedList.size() - 1);
         double medianValue = getRoundedValue(getMedian(sortedList));
         medianValues.add(medianValue);
         System.out.println(medianValue);
     }
     return medianValues;
  }

  private static void sort(List<Double> list, int leftIndex, int rightIndex) {
    if(leftIndex < rightIndex) {
      int mid = (leftIndex + rightIndex) / 2;
      //sort left
      sort(list, leftIndex, mid);
      // sort right
      sort(list, mid + 1, rightIndex);
      //merge
      merge(list, leftIndex, mid, rightIndex);
    }
  }

  private static void merge(List<Double> list, int leftIndex, int mid, int rightIndex) {
    // get subarrays lengths
    int leftLength = mid - leftIndex + 1;
    int rightLength = rightIndex - mid;
    // fill both subarrays up to mid point
    double[] leftArray = new double[leftLength];
    double[] rightArray = new double[rightLength];
    int counter = leftIndex;
    for(int i = 0; i < leftLength; i++) {
      leftArray[i] = list.get(counter);
      counter++;
    }
    counter = mid + 1;
    for(int i = 0; i < rightLength; i++) {
      rightArray[i] = list.get(counter);
      counter++;
    }
    // compare left vs right and replace smallest value
    int j = 0;
    int i = 0;
    counter = leftIndex;
    while(i < leftLength && j < rightLength) {
      if(leftArray[i] <= rightArray[j]) {
        list.set(counter, leftArray[i]);
        i++;
      } else {
        list.set(counter, rightArray[j]);
        j++;
      }
      counter++;
    }
    // fill array with remaining values from subarrays
    while(i < leftLength) {
      list.set(counter, leftArray[i]);
      counter++;
      i++;
    }
    while(j < rightLength) {
      list.set(counter, rightArray[j]);
      counter++;
      j++;
    }
  }

  private static Double getMedian(List<Double> list) {
    if(lengthIsOdd(list)) {
      return list.get((int) (list.size() / 2));
    } else {
      double number1 = list.get(list.size() / 2);
      double number2 = list.get(((int)(list.size() / 2)) - 1);
      return (number1 + number2) / 2;
    }
  }

  private static boolean lengthIsOdd(List<Double> list) {
    return list.size() % 2 != 0;
  }

  private static double getRoundedValue(Double number) {
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    decimalFormat.setMaximumFractionDigits(1);
    return Double.parseDouble(decimalFormat.format(number));
  }
}
