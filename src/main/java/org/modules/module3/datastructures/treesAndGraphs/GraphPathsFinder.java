package org.modules.module3.datastructures.treesAndGraphs;

import java.util.List;
import java.util.ArrayList;

public class GraphPathsFinder {
  public List<List<Integer>> findAllPaths(List<List<Integer>> graph, int source, int target) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    boolean[] visited = new boolean[graph.size()];

    dfs(graph, source, target, visited, currentPath, allPaths);

    return allPaths;
  }

  private void dfs(List<List<Integer>> graph, int current, int target, boolean[] visited,
                         List<Integer> currentPath, List<List<Integer>> allPaths) {
    visited[current] = true;
    currentPath.add(current);

    if (current == target) {
      allPaths.add(new ArrayList<>(currentPath));
    } else {
      for (int neighbor : graph.get(current)) {
        if (!visited[neighbor]) {
          dfs(graph, neighbor, target, visited, currentPath, allPaths);
        }
      }
    }

    visited[current] = false;
    currentPath.remove(currentPath.size() - 1);
  }
}
