package org.modules.module3.algorithms.dfs;

import java.util.List;

public class NearestPlaceFinder {
  public int findShortestPathSteps(List<List<Integer>> graph) {
    for(int i = 0; i < graph.size(); i++) {
      for(int j = 0; j < graph.get(0).size(); j++) {
        if(graph.get(i).get(j) == 9) {
          dfs(graph, i, j, 1);
        }
      }
    }
    return graph.get(0).get(0) - 2;
  }

  private void dfs(List<List<Integer>> graph, int x, int y, int distance) {
    if(x < 0 || y < 0 || x >= graph.size() || y >= graph.get(0).size() || graph.get(x).get(y) == 0 ||
          (graph.get(x).get(y) < distance && graph.get(x).get(y) != 1)) {
      return;
    }

    graph.get(x).set(y, distance + 1);

    dfs(graph, x - 1, y, distance + 1);
    dfs(graph, x + 1, y, distance + 1);
    dfs(graph, x, y - 1, distance + 1);
    dfs(graph, x, y + 1, distance + 1);
  }
}
