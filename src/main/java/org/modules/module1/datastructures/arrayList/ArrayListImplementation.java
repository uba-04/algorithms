package org.modules.module1.datastructures.arrayList;

import java.util.Arrays;

public class ArrayListImplementation<E> {
  private static final int DEFAULT_SIZE = 10;
  private Object[] array = {};
  private int size;

  public ArrayListImplementation() {
    this.array = new Object[DEFAULT_SIZE];
    this.size = 0;
  }

  public ArrayListImplementation(int size) {
    this.array = new Object[size];
    this.size = 0;
  }

  public void add(E element) {
    if(size == array.length) {
      increaseCapacity();
    }
    array[size] = element;
    size++;
  }

  public E remove(int index) {
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

  public E get(int index) {
    if(index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
    }
    return (E) array[index];
  }

  public int size() {
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
