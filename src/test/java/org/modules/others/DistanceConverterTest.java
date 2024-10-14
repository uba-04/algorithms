package org.modules.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceConverterTest {

  @Test
  void convertDistanceUsingDFS_returnsCorrectConversion() {
    // given
    String startUnit = "km";
    String endUnit = "cm";
    double startValue = 2;
    String startUnit2 = "km";
    String endUnit2 = "yard";

    // when
    double result = DistanceConverter.convertDistanceUsingDFS(startValue, startUnit, endUnit);
    double result2 = DistanceConverter.convertDistanceUsingDFS(startValue, startUnit2, endUnit2);

    // then
    assertEquals(200_000.0, result);
    assertEquals(2187.224715659764, result2);
  }

  @Test
  void convertDistanceUsingDFS_returnsZero_whenNoConversionIsAvailable() {
    // given
    String startUnit1 = "wrongUnit";
    String endUnit1 = "km";
    double startValue1 = 2;
    String startUnit2 = "cm";
    String endUnit2 = "wrongUnit";
    double startValue2 = 4.6;

    // when
    double result1 = DistanceConverter.convertDistanceUsingDFS(startValue1, startUnit1, endUnit1);
    double result2 = DistanceConverter.convertDistanceUsingDFS(startValue2, startUnit2, endUnit2);

    // then
    assertEquals(0.0, result1);
    assertEquals(0.0, result2);
  }

  @Test
  void convertDistanceUsingBFS_returnsCorrectConversion() {
    // given
    String startUnit = "km";
    String endUnit = "cm";
    double startValue = 2;
    String startUnit2 = "km";
    String endUnit2 = "yard";

    // when
    double result = DistanceConverter.convertDistanceUsingBFS(startValue, startUnit, endUnit);
    double result2 = DistanceConverter.convertDistanceUsingBFS(startValue, startUnit2, endUnit2);

    // then
    assertEquals(200_000.0, result);
    assertEquals(2187.224715659764, result2);
  }

  @Test
  void convertDistanceUsingBFS_returnsZero_whenNoConversionIsAvailable() {
    // given
    String startUnit1 = "wrongUnit";
    String endUnit1 = "km";
    double startValue1 = 2;
    String startUnit2 = "cm";
    String endUnit2 = "wrongUnit";
    double startValue2 = 4.6;

    // when
    double result1 = DistanceConverter.convertDistanceUsingBFS(startValue1, startUnit1, endUnit1);
    double result2 = DistanceConverter.convertDistanceUsingBFS(startValue2, startUnit2, endUnit2);

    // then
    assertEquals(0.0, result1);
    assertEquals(0.0, result2);
  }
}
