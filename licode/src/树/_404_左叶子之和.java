package 树;

public class _404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
       return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            sum += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            sum += dfs(root.right);
        }
        return sum;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
