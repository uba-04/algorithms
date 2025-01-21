package org.modules.module2.algorithms.bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BipartiteGraphTest {

  private final BipartiteGraph bipartiteGraph = new BipartiteGraph();
  private List<List<Integer>> graph;

  @BeforeEach
  void setUp() {
    graph = new ArrayList<>();
  }

  @Test
  void isBipartite_returnsTrue() {
    // Arrange
    graph.add(List.of(1, 2));
    graph.add(List.of(0, 3));
    graph.add(List.of(0, 3));
    graph.add(List.of(1, 2));

    // Act
    boolean result = bipartiteGraph.isBapartite(graph);

    // Assert
    assertTrue(result);
  }

  @Test
  void isBipartite_returnsTrue2() {
    // Arrange
    graph.add(List.of(1));
    graph.add(List.of(0, 2));
    graph.add(List.of(1));

    // Act
    boolean result = bipartiteGraph.isBapartite(graph);

    // Assert
    assertTrue(result);
  }

  @Test
  void isBipartite_returnsFalse() {
    // Arrange
    graph.add(List.of(2, 3));
    graph.add(List.of(3));
    graph.add(List.of(0, 3));
    graph.add(List.of(0, 1, 2));

    // Act
    boolean result = bipartiteGraph.isBapartite(graph);

    // Assert
    assertFalse(result);
  }

  @Test
  void isBipartite_returnsFalse2() {
    // Arrange
    graph.add(List.of(1, 2));
    graph.add(List.of(0, 2));
    graph.add(List.of(0, 1));

    // Act
    boolean result = bipartiteGraph.isBapartite(graph);

    // Assert
    assertFalse(result);
  }
}
