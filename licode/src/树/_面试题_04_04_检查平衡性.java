package 树;

public class _面试题_04_04_检查平衡性 {
    // 这个函数用于检测以这个root为节点的二叉树是不是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2 ?
                isBalanced(root.left) && isBalanced(root.right) : false;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
