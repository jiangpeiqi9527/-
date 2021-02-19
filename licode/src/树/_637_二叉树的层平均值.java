package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = cengOrder(root);
        return res;
    }

    private List<Double> cengOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(sum / size);
        }
        return list;
    }
}
