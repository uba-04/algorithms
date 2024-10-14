package org.modules.module3.datastructures.treesAndGraphs;

import org.modules.module2.algorithms.bfs.TreeNode;

public class BalancedBinaryTreeValidator {
  public boolean isBinaryTreeBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }

    return isBinaryTreeBalanced(root.left) && isBinaryTreeBalanced(root.right);
  }

  private int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
