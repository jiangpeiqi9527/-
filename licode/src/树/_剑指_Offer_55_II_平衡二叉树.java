package 树;

public class _剑指_Offer_55_II_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 ? isBalanced(root.left) && isBalanced(root.right) : false;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
