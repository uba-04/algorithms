package org.modules.module2.datastructures.hashTables;

public class HashTable<K, V> {
  private static final int CAPACITY = 16;
  private Node<K, V>[] table;
  private int size;

  public HashTable() {
    table = new Node[CAPACITY];
    size = 0;
  }

  public V get(K key) {
    int index = getIndex(key);
    if(index < 0 || index >= table.length) {
      throw new IndexOutOfBoundsException(String.format("Index %s out of bounds %s.", index, table.length));
    }
    Node<K,V> node = table[index];
    if(node == null) {
      throw new NullPointerException("Element at the specified key does not exist.");
    }
    while(node != null) {
      if(node.key.equals(key)) {
        return node.value;
      }
      node = node.next;
    }
    return null;
  }

  public void put(K key, V value) {
    int index = getIndex(key);
    if(table[index] != null) {
      Node<K,V> node = table[index];
      while(node != null) {
        if(node.key.equals(key)) {
          node.value = value;
          return;
        }
        node = node.next;
      }
      node = new Node<>(key, value);
    } else {
      table[index] = new Node<>(key, value);
    }
    size++;
  }

  public void remove(K key) {
    int index = getIndex(key);
    if(index < 0 || index >= table.length) {
      throw new IndexOutOfBoundsException(String.format("Index %s out of bounds %s.", index, table.length));
    }
    Node<K,V> currentNode = table[index];
    if(currentNode == null) {
      throw new NullPointerException("Element at the specified key does not exist.");
    }
    Node<K,V> previousNode = null;

    while(currentNode != null) {
      if(currentNode.key.equals(key)) {
        if(previousNode == null) {
          table[index] = currentNode.next;
        } else {
          previousNode.next = currentNode.next;
        }
        size--;
        return;
      }
      previousNode = currentNode;
      currentNode = currentNode.next;
    }
  }

  public int size() {
    return this.size;
  }

  private int getIndex(K key) {
    int hashCode = key.hashCode();
    return Math.abs(hashCode) % table.length;
  }

  private static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }
}
