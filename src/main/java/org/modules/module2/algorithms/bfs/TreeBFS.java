package org.modules.module2.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
  public void traverseTree(TreeNode tree) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(tree);

    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println("Value: " + node.value);
      if(node.left != null) {
        queue.offer(node.left);
      }
      if(node.right != null) {
        queue.offer(node.right);
      }
    }
  }
}
