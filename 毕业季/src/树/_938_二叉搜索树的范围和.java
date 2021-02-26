package 树;

public class _938_二叉搜索树的范围和 {
    private int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return res;
    }

    private void helper(TreeNode root, int low, int high) {
        if (root == null) return;

        helper(root.left,low,high);

        if (root.val >= low && root.val <= high) {
            res += root.val;
        }

        helper(root.right,low,high);
    }
}
