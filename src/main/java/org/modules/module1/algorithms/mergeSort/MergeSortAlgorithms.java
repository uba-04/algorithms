package org.modules.module1.algorithms.mergeSort;

import org.modules.module1.datastructures.linkedList.ListNode;

import java.util.Arrays;
import java.util.List;

public class MergeSortAlgorithms {

  public void mergeSort(int[] array, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      int mid = (leftIndex + rightIndex) / 2;

      mergeSort(array, leftIndex, mid);
      mergeSort(array , mid + 1, rightIndex);
      merge(array, leftIndex, mid, rightIndex);
    }
  }

  private void merge(int[] arr, int leftIndex, int mid, int rightIndex) {
    int n1 = mid - leftIndex + 1;
    int n2 = rightIndex - mid;

    int leftTemp[] = new int [n1];
    int rightTemp[] = new int [n2];

    System.arraycopy(arr, leftIndex, leftTemp, 0, n1);
    for (int j=0; j<n2; ++j)
      rightTemp[j] = arr[mid + 1 + j];

    int i = 0, j = 0;
    int k = leftIndex;
    while (i < n1 && j < n2) {
      if (leftTemp[i] <= rightTemp[j]) {
        arr[k] = leftTemp[i];
        i++;
      } else {
        arr[k] = rightTemp[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = leftTemp[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = rightTemp[j];
      j++;
      k++;
    }
  }

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    // Step 1: split the list into two halves
    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;

    // Step 2: sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // Step 3: merge the two sorted lists
    return merge(l1, l2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null)
      p.next = l1;
    else
      p.next = l2;

    return l.next;
  }

  public void sortStringArray(String[] array, int leftIndex, int rightIndex) {
    if(leftIndex < rightIndex) {
      int mid = (leftIndex + rightIndex) / 2;
      sortStringArray(array, leftIndex, mid);
      sortStringArray(array, mid + 1, rightIndex);
      mergeStringArrays(array, leftIndex, mid, rightIndex);
    }
  }

  private void mergeStringArrays(String[] array, int leftIndex, int mid, int rightIndex) {
    String[] leftArray = Arrays.copyOfRange(array, leftIndex, mid + 1);
    String[] rightArray = new String[rightIndex - mid];
    for(int i = 0; i < rightArray.length; i++) {
      rightArray[i] = array[++mid];
    }

    int leftArrayIndex = 0;
    int rightArrayIndex = 0;
    int mergedIndex = leftIndex;
    while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
      if(leftArray[leftArrayIndex].compareTo(rightArray[rightArrayIndex]) < 0) {
        array[mergedIndex] = leftArray[leftArrayIndex];
        leftArrayIndex++;
      } else {
        array[mergedIndex] = rightArray[rightArrayIndex];
        rightArrayIndex++;
      }
      mergedIndex++;
    }

    while(leftArrayIndex < leftArray.length) {
      array[mergedIndex] = leftArray[leftArrayIndex];
      mergedIndex++;
      leftArrayIndex++;
    }
    while(rightArrayIndex < rightArray.length) {
      array[mergedIndex] = rightArray[rightArrayIndex];
      mergedIndex++;
      rightArrayIndex++;
    }
  }

  public void mergeSortList(List<Double> list) {
    sort(list, 0, list.size() - 1);
  }

  private void sort(List<Double> list, int leftIndex, int rightIndex) {
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

  private void merge(List<Double> list, int leftIndex, int mid, int rightIndex) {
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
}
