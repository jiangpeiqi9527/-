package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/submissions/
 */
public class 剑指Offer_55_二叉树的深度 {
    // 好方法
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
//    }

    // 比较挫
      public int maxDepth(TreeNode root) {
          if (root == null) return 0;
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          int height = 0;
          int levelSize = 1;
          while (!queue.isEmpty()) {
              TreeNode node = queue.poll();
              levelSize--;
              if (node.left != null) {
                  queue.offer(node.left);
              }
              if (node.right != null) {
                  queue.offer(node.right);
              }
              if (levelSize == 0) {
                  levelSize = queue.size();
                  height++;
              }
          }
          return height;
      }
}
