package org.modules.module2.datastructures.hashTables;

import java.util.HashMap;
import java.util.Map;

public class HashTableChallenges {
  public int findNumberOfSubarraysWhichSumEqualsK(int[] numbers, int k) {
    int count = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for(int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
      if(map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}
