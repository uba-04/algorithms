package org.modules.module3.algorithms.dfs;

import java.util.List;

public class GraphTraversal {
  public void traverseGraph(List<List<Integer>> graph) {
    int starter = 0;
    boolean[] visits = new boolean[graph.size()];
    dfs(graph, visits, starter);
  }

  private void dfs(List<List<Integer>> graph, boolean[] visits, int node) {
    System.out.println("Node: " + node);
    visits[node] = true;
    for(int value : graph.get(node)) {
      if(!visits[value]) {
        dfs(graph, visits, value);
      }
    }
  }
}
