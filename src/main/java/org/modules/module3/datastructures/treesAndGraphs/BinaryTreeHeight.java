package org.modules.module3.datastructures.treesAndGraphs;


import org.modules.module2.algorithms.bfs.TreeNode;

public class BinaryTreeHeight {
  public static int height(TreeNode root) {
    return dfs(root, 0);
  }

  private static int dfs(TreeNode node, int height) {
    if(node == null) {
      return 0;
    }
    int leftHeight = height;
    int rightHeight = height;
    if(node.left != null) {
      leftHeight = dfs(node.left, leftHeight + 1);
    }
    if(node.right != null) {
      rightHeight = dfs(node.right, rightHeight + 1);
    }
    return Integer.max(leftHeight, rightHeight);
  }
}
