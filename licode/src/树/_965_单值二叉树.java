package 树;

public class _965_单值二叉树 {
    private int value;
    public boolean isUnivalTree(TreeNode root) {
        value = root.val;
        boolean flag = isUnival(root);
        return false;
    }

    private boolean isUnival(TreeNode root) {
        if (root == null) return true;
        boolean flag = value == root.val;
        return flag && isUnival(root.left) && isUnival(root.right);
    }
}
