package 树;

import java.util.LinkedList;
import java.util.Queue;

public class _958_二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode pre = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (pre == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            pre = node;
        }
        return true;
    }
}
