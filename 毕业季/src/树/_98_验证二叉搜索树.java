package 树;

public class _98_验证二叉搜索树 {
    // 方法一：中序遍历
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private long pre = Long.MIN_VALUE;
    private boolean inorder(TreeNode root) {
        if (root == null) return true;
        boolean left = inorder(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = inorder(root.right);
        return left && right;
    }
}
