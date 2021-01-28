package 热门.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _剑指_Offer_37_序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String sub = data.substring(1, data.length() - 1);
        String[] split = sub.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[index])) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.offer(node.left);
            }
            index++;
            if (!"null".equals(split[index])) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }


}
