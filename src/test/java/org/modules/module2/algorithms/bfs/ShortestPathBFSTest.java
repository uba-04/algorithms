package org.modules.module2.algorithms.bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShortestPathBFSTest {

  private final ShortestPathBFS shortestPathBFS = new ShortestPathBFS();
  private List<List<Integer>> graph;

  @BeforeEach
  void setup() {
    graph = new ArrayList<>();
  }

  @Test
  void findShortestPath_returnsShortestPath() {
    // Given
    graph.add(List.of(1, 2));
    graph.add(List.of(0, 3, 4));
    graph.add(List.of(0, 5));
    graph.add(List.of(1, 5));
    graph.add(List.of(1));
    graph.add(List.of(2));
    List<Integer> expectedPath = new ArrayList<>(List.of(0, 2, 5));

    // When
    List<Integer> path = shortestPathBFS.findShortestPath(graph, 0, 5);

    // Then
    assertEquals(expectedPath, path);
  }
}
