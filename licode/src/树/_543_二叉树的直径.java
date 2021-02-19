package 树;

public class _543_二叉树的直径 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int d = depth(root.left) + depth(root.right);
        return Math.max(d,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
