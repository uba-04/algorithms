package org.modules.module1.datastructures.arrayList;

import java.util.Arrays;

public class ThreadSafeArrayListImplementation<E> {
  private static final int DEFAULT_SIZE = 10;
  private volatile Object[] array = {};
  private volatile int size;

  public ThreadSafeArrayListImplementation() {
    this.array = new Object[DEFAULT_SIZE];
    this.size = 0;
  }

  public ThreadSafeArrayListImplementation(int size) {
    this.array = new Object[size];
    this.size = 0;
  }

  public synchronized boolean add(E element) {
    if(size == array.length) {
      increaseCapacity();
    }
    array[size] = element;
    size++;
    return true;
  }

  public synchronized E remove(int index) {
    if(index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    if(size <= (int)(array.length / 1.5)) {
      decreaseCapacity();
    }
    E element = (E) array[index];
    array[index] = null;
    size--;
    return element;
  }

  public synchronized E get(int index) {
    if(index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
    }
    return (E) array[index];
  }

  public synchronized int size() {
    return size;
  }

  private void increaseCapacity() {
    int newLength = (int) (array.length * 1.5);
    array = Arrays.copyOf(array, newLength);
  }

  private void decreaseCapacity() {
    int newLength = (int) (array.length / 1.5);
    array = Arrays.copyOf(array, newLength);
  }
}
