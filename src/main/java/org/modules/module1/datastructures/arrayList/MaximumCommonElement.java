package org.modules.module1.datastructures.arrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MaximumCommonElement {
  private Vector vector1;
  private Vector vector2;
  Map<Object, Integer> occurrences = new HashMap<>();

  public MaximumCommonElement(Vector vector1, Vector vector2) {
    this.vector1 = vector1;
    this.vector2 = vector2;
  }

  public Object getMaximumCommonElement() {
    calculateConcurrences();

    int maxOccurrences = 0;
    Object maximumCommonElement = null;
    for (Map.Entry<Object, Integer> entry : occurrences.entrySet()) {
      Integer value = entry.getValue();
      if (value > maxOccurrences) {
        maxOccurrences = value;
        maximumCommonElement = entry.getKey();
      }
    }

    return maximumCommonElement;
  }

  private void calculateConcurrences() {
    for(int i = 0; i < vector1.size(); i++) {
      if(occurrences.containsKey(vector1.get(i))) {
        occurrences.put(vector1.get(i), occurrences.get(vector1.get(i)) + 1);
      } else {
        occurrences.put(vector1.get(i), 1);
      }
    }

    for(int i = 0; i < vector2.size(); i++) {
      if(occurrences.containsKey(vector2.get(i))) {
        occurrences.put(vector2.get(i), occurrences.get(vector2.get(i)) + 1);
      } else {
        occurrences.put(vector2.get(i), 1);
      }
    }
  }
}
