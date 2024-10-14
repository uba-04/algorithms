package org.modules;

import org.modules.module2.algorithms.bfs.TreeNode;

import java.util.*;

public class TreeTraverser {
  public void dfsTraversal(TreeNode root) {
    if(root == null) {
      return;
    }
    System.out.println(root.value);
    dfsTraversal(root.left);
    dfsTraversal(root.right);
  }

  public void bfsTraversal(TreeNode root) {
    if(root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println(node.value);
      if(node.left != null) {
        queue.offer(node.left);
      }
      if(node.right != null) {
        queue.offer(node.right);
      }
    }
  }
}
