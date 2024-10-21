package org.modules.module1.datastructures.arrayList;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumCommonElementTest {

  @Test
  void getMaximumCommonElement_returnsMaximumCommonElement() {
    // Given
    Vector<String> vector1 = new Vector<>();
    vector1.add("a");
    vector1.add("b");
    vector1.add("c");
    vector1.add("c");
    Vector<String> vector2 = new Vector<>();
    vector2.add("a");
    vector2.add("b");
    vector2.add("a");
    vector2.add("d");
    var maximumCommonElement = new MaximumCommonElement(vector1, vector2);
    String expected = "a";

    // When
    var maxElement = (String) maximumCommonElement.getMaximumCommonElement();

    // Then
    assertEquals(expected, maxElement);
  }
}
