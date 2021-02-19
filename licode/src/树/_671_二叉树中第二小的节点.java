package 树;

public class _671_二叉树中第二小的节点 {
    private Integer flag;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int bigger = Math.max(root.left.val,root.right.val);
        flag = root.val;

        dfs(root);
        return flag == root.val ? (bigger == flag ? -1 : bigger) : flag;
    }
    private void dfs(TreeNode root) {
        if (root == null || root.left == null) return;

        int value = Math.min(root.left.val,root.right.val);
        if (value != flag) {
            flag = value;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
