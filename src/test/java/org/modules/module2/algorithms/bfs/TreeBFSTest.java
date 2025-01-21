package org.modules.module2.algorithms.bfs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeBFSTest {

  private final TreeBFS treeBFS = new TreeBFS();
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void traverseTree_printsTreeValues() {
    // Given
    TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    tree.left.left = new TreeNode(4);
    tree.left.right = new TreeNode(5);
    tree.right.left = new TreeNode(6);
    tree.right.right = new TreeNode(7);
    String expectedOutput = "Value: 1" + System.lineSeparator() +
          "Value: 2" + System.lineSeparator() +
          "Value: 3" + System.lineSeparator() +
          "Value: 4" + System.lineSeparator() +
          "Value: 5" + System.lineSeparator() +
          "Value: 6" + System.lineSeparator() +
          "Value: 7";

    // When
    treeBFS.traverseTree(tree);

    // Then
    assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
  }
}
