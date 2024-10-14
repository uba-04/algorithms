package org.modules.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DistanceConverter {
  private static Map<String, Map<String, Double>> map = new HashMap<>();

  static {
    map.put("km", new HashMap<>(Map.of("m", 1000.0)));
    map.put("inches", new HashMap<>(Map.of("feet", 0.0833333)));
    map.put("m", new HashMap<>(Map.of("cm", 100.0)));
    map.get("km").put("mile", 0.621371);
    map.put("feet", new HashMap<>(Map.of("yard", 0.333333)));
    map.put("cm", new HashMap<>(Map.of("inches", 0.393701)));
  }

  public static double convertDistanceUsingDFS(double startValue, String startUnit, String endUnit) {
    if(map.get(startUnit) == null) {
      return 0.0;
    }
    return dfs(startValue, startUnit, endUnit, 1.0);
  }

  private static double dfs(double startValue, String parentUnit, String endUnit, double conversionRate) {
    if(parentUnit.equals(endUnit)) {
      return startValue * conversionRate;
    }
    Map<String, Double> conversions = map.get(parentUnit);
    if(conversions == null) {
      return 0.0;
    }
    for(Map.Entry<String, Double> entry : conversions.entrySet()) {
      return dfs(startValue, entry.getKey(), endUnit, conversionRate * entry.getValue());
    }
    return 0.0;
  }

  public static double convertDistanceUsingBFS(double startValue, String startUnit, String endUnit) {
    if(map.get(startUnit) == null) {
      return 0.0;
    }
    Queue<Object[]> queue = new LinkedList<>();
    queue.offer(new Object[]{startUnit, 1.0});
    while(!queue.isEmpty()) {
      Object[] objects = queue.poll();
      String currentUnit = (String) objects[0];
      double conversionRate = (double) objects[1];
      if(currentUnit.equals(endUnit)) {
        return startValue * conversionRate;
      }
      Map<String, Double> value = map.get(currentUnit);
      if(value != null) {
        for(Map.Entry<String, Double> entry : value.entrySet()) {
          queue.offer(new Object[]{entry.getKey(), conversionRate * entry.getValue()});
        }
      }
    }
    return 0.0;
  }
}
