package org.modules.module2.datastructures.hashTables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

  private HashTable<Integer, String> hashTable;

  @BeforeEach
  void setUp() {
    hashTable = new HashTable<>();
    hashTable.put(1, "one");
    hashTable.put(2, "two");
    hashTable.put(3, "three");
  }

  @Test
  void get_returnsCorrectElement() {
    // Given
    int key = 2;
    String expectedResult = "two";

    // When
    String actualResult = hashTable.get(key);

    // Then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void get_throwNullPointerException_whenElementDoesNotExist() {
    // Given
    int key = 6;

    // When & Then
    assertThrows(NullPointerException.class, () -> hashTable.get(key));
  }

  @Test
  void get_returnsNull_whenNodeIsNotFoundAndIndexIsValid() {
    // Given
    int key = -6546545;

    // When & Then
    assertNull(hashTable.get(key));
  }

  // TODO: Continue adding unit tests
}
