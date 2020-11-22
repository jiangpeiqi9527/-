package 树;

import java.util.*;

public class _144_二叉树的前序遍历 {
    private List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) return Arrays.asList();
        list.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return list;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return output;
    }
}
