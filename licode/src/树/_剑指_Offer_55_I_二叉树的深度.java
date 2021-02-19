package 树;

public class _剑指_Offer_55_I_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return getMaxHeight(root,1);
    }

    private int getMaxHeight(TreeNode root, int i) {
        if (root == null) return i;
        return Math.max(getMaxHeight(root.left, i + 1), getMaxHeight(root.right, i + 1));
    }
}
