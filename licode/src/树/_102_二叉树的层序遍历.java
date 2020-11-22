package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {
    private  List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        List<Integer> levelList = new LinkedList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelList.add(node.val);
            }
            list.add(levelList);
        }
        return this.list;
    }
}
