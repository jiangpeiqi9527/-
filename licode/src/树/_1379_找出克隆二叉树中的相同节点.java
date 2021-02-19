package 树;

public class _1379_找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode node = helper(cloned,target);
        return node;
    }

    private TreeNode helper(TreeNode cloned, TreeNode target) {
        if (cloned == null) return null;
        if (cloned.val == target.val) return cloned;
        TreeNode leftNode = helper(cloned.left,target);
        TreeNode rightNode = helper(cloned.right ,target);
        return leftNode != null ? leftNode : rightNode != null ? rightNode : null;
    }
}
