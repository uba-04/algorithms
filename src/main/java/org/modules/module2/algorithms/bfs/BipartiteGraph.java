package org.modules.module2.algorithms.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
  public boolean isBapartite(List<List<Integer>> graph) {
    int[] colors = new int[graph.size()];
    Arrays.fill(colors, -1);
    colors[0] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    boolean[] visits = new boolean[graph.size()];

    while(!queue.isEmpty()) {
      int currentNode = queue.poll();
      visits[currentNode] = true;
      for(int neighbor : graph.get(currentNode)) {
        if(visits[neighbor] && colors[neighbor] == colors[currentNode]) {
          return false;
        } else if(!visits[neighbor]){
          colors[neighbor] = colors[currentNode] == 0 ? 1 : 0;
          queue.offer(neighbor);
        }
      }
    }
    return true;
  }
}
