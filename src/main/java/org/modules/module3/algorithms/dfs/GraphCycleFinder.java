package org.modules.module3.algorithms.dfs;

import java.util.List;

public class GraphCycleFinder {
  public static boolean hasCycle(List<List<Integer>> graph) {
    int numNodes = graph.size();
    boolean[] visited = new boolean[numNodes];
    boolean[] recursionStack = new boolean[numNodes];

    return hasCycleDFS(graph, 0, visited, recursionStack);
  }

  public static boolean hasCycleDFS(List<List<Integer>> graph, int current, boolean[] visited, boolean[] recursionStack) {
    visited[current] = true;
    recursionStack[current] = true;

    for (int neighbor : graph.get(current)) {
      if (!visited[neighbor]) {
        if (hasCycleDFS(graph, neighbor, visited, recursionStack)) {
          return true;
        }
      } else if (recursionStack[neighbor]) {
        return true;
      }
    }

    recursionStack[current] = false;
    return false;
  }
}
