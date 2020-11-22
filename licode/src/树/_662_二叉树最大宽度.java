package 树;

import java.util.Deque;
import java.util.LinkedList;

public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        root.val = 0;
        deque.add(root);
        int sum = 0;
        int res = 0;
        while (!deque.isEmpty()) {
            sum = deque.size();
            // 队头和队尾的编号值求差用来更新宽度
            res = Math.max(res,deque.getLast().val - deque.getFirst().val + 1);
            // 一次处理一层，进入这个循环前队列中是一层的所有非空节点
            while (sum > 0) {
                TreeNode node = deque.poll();
                // 子节点入队前修改 val, val = 满二叉树中节点编号
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    deque.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    deque.add(node.right);
                }
                sum--;
            }
        }
        return res;
    }
}
