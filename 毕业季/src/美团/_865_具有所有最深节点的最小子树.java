package 美团;

import 树.TreeNode;

public class _865_具有所有最深节点的最小子树 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else if (left < right) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return root;
        }
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
