package org.modules.module3.datastructures.treesAndGraphs;

import org.modules.module2.algorithms.bfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
  public void preOrderTraversal(TreeNode root) {
    if(root == null) {
      return;
    }
    System.out.println("Value: " + root.value);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public void inOrderTraversal(TreeNode root) {
    if(root == null) {
      return;
    }
    inOrderTraversal(root.left);
    System.out.println("Value: " + root.value);
    inOrderTraversal(root.right);
  }

  public void postOrderTraversal(TreeNode root) {
    if(root == null) {
      return;
    }
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.println("Value: " + root.value);
  }

  public void levelOrderTraversal(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println("Value: " +  node.value);
      if(node.left != null) {
        queue.offer(node.left);
      }
      if(node.right != null) {
        queue.offer(node.right);
      }
    }
  }
}
