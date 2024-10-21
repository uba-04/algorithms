package org.modules.module1.datastructures.arrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListImplementationTest {

  ArrayListImplementation<Integer> arrayList;

  @BeforeEach
  void setUp() {
    arrayList = new ArrayListImplementation<>();
  }

  @Test
  void add_addsElementToArrayListAndIncreasesSize_whenUsingDefaultConstructor() {
    // Given
    int element = 5;
    int expectedSize = 1;

    // When
    arrayList.add(element);

    // Then
    assertEquals(expectedSize, arrayList.size());
    assertEquals(element, arrayList.get(0));
  }

  @Test
  void add_addsElementToArrayListAndIncreasesSize_whenUsingParameterizedConstructor() {
    // Given
    ArrayListImplementation<Integer> arrayList = new ArrayListImplementation<>(2);
    int element1 = 5;
    int element2 = 10;
    int element3 = 15;
    int expectedSize = 3;

    // When
    arrayList.add(element1);
    arrayList.add(element2);
    arrayList.add(element3);

    // Then
    assertEquals(expectedSize, arrayList.size());
  }

  @Test
  void remove_throwsIndexOutOfBoundsException_whenIndexIsNegative() {
    // Given
    int index = -1;

    // When and Then
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(index));
  }

  @Test
  void remove_throwsIndexOutOfBoundsException_whenIndexIsGreaterThanSize() {
    // Given
    int index = 1;

    // When and Then
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(index));
  }

  @Test
  void remove_removesElementFromArrayListAndDecreasesSize_whenElementIsPresent() {
    // Given
    int element = 5;
    arrayList.add(element);
    int expectedSize = 0;

    // When
    int result = arrayList.remove(0);

    // Then
    assertEquals(expectedSize, arrayList.size());
    assertEquals(element, result);
  }

  @Test
  void get_throwsIndexOutOfBoundsException_whenIndexIsNegative() {
    // Given
    int index = -1;

    // When and Then
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(index));
  }

  @Test
  void get_throwsIndexOutOfBoundsException_whenIndexIsGreaterThanSize() {
    // Given
    int index = 1;

    // When and Then
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(index));
  }

  @Test
  void get_throwsIndexOutOfBoundsException_whenIndexIsEqualToSize() {
    // Given
    int index = 0;

    // When and Then
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(index));
  }

  @Test
  void get_returnsElementFromArrayList_whenElementIsPresent() {
    // Given
    int element = 5;
    arrayList.add(element);

    // When
    int result = arrayList.get(0);

    // Then
    assertEquals(element, result);
  }

  @Test
  void size_returnsSizeOfArrayList() {
    // Given
    int element = 5;
    arrayList.add(element);
    int expectedSize = 1;

    // When
    int result = arrayList.size();

    // Then
    assertEquals(expectedSize, result);
  }
}
