package org.modules.module2.algorithms.bfs;

import java.util.*;

public class ShortestPathBFS {

  public List<Integer> findShortestPath(List<List<Integer>> graph, int startNode, int targetNode) {
    int numNodes = graph.size();
    boolean[] visited = new boolean[numNodes];
    int[] parent = new int[numNodes];

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(startNode);
    visited[startNode] = true;

    while (!queue.isEmpty()) {
      int currentNode = queue.poll();

      if (currentNode == targetNode) {
        break; // Found the target node, exit the loop
      }

      for (int neighbor : graph.get(currentNode)) {
        if (!visited[neighbor]) {
          queue.offer(neighbor);
          visited[neighbor] = true;
          parent[neighbor] = currentNode;
        }
      }
    }

    return reconstructPath(parent, startNode, targetNode);
  }

  public List<Integer> reconstructPath(int[] parent, int startNode, int targetNode) {
    List<Integer> path = new ArrayList<>();
    int currentNode = targetNode;

    while (currentNode != startNode) {
      path.add(currentNode);
      currentNode = parent[currentNode];
    }

    path.add(startNode);
    Collections.reverse(path);
    return path;
  }
}
