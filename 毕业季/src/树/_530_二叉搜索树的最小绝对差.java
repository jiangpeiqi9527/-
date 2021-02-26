package 树;

public class _530_二叉搜索树的最小绝对差 {
    // 思路：中序遍历，让每一个节点都与他的前驱节点做差
    public int getMinimumDifference(TreeNode root) {
        return inorder(root);
    }
    private Integer pre;
    private int minAbs = Integer.MAX_VALUE;
    private int inorder(TreeNode root) {
        if (root == null) return minAbs;
        inorder(root.left);
        if (pre != null) minAbs = Math.min(minAbs, root.val - pre);
        pre = root.val;
        inorder(root.right);
        return minAbs;
    }
}
