package 树;

public class _938_二叉搜索树的范围和 {
    private int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        getRangeSum(root, low, high);
        return res;
    }

    private int getRangeSum(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val < low) {
                getRangeSum(root.right, low, high);
            } else if (root.val > high) {
                getRangeSum(root.left, low, high);
            } else {
                res += root.val;
                getRangeSum(root.left,low,high);
                getRangeSum(root.right,low,high);
            }
        }
        return res;
    }
}
