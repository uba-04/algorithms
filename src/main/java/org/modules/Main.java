package org.modules;

import org.modules.module1.algorithms.StringAlgorithms;
import org.modules.module1.algorithms.mergeSort.MergeSortAlgorithms;
import org.modules.others.BalancedBracketsValidator;
import org.modules.others.Contacts;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Double> list = new ArrayList<>();
    list.add(1.0);
    list.add(10.0);
    list.add(7.0);
    list.add(2.0);
    list.add(11.0);
    list.add(Double.valueOf(5));
    list.add(3.0);
    list.add(6.0);
    list.add((double) 0);
    list.add((double) -1);
    list.add(13.0);
    list.add(10.0);
    MergeSortAlgorithms mergeSortAlgorithms = new MergeSortAlgorithms();
    mergeSortAlgorithms.mergeSortList(list);
    for(Double number : list) {
      System.out.println(number);
    }
    int number = 7 /2;
    System.out.println(number);
  }
}