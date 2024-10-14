package org.modules.others;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbersConverter {

  private static final Map<Integer, String> map = new HashMap<>();
  private static final int[] array = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

  static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  public static String fromIntToRoman(int number) {
    StringBuilder stringBuilder = new StringBuilder();
    return recursion(stringBuilder, number, 0);
  }

  private static String recursion(StringBuilder stringBuilder, int number, int index) {
    if(number == 0 || index == array.length) {
      return stringBuilder.toString();
    }
    int intValue = array[index];
    if(number >= intValue) {
      stringBuilder.append(map.get(intValue));
      number -= intValue;
      if(number >= intValue) {
        return recursion(stringBuilder, number, index);
      } else {
        return recursion(stringBuilder, number, index + 1);
      }
    } else {
      return recursion(stringBuilder, number, index + 1);
    }
  }
}
