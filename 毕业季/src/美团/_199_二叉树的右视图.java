package 美团;

import 树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
