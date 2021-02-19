package 树;

public class _783_二叉搜索树节点最小距离 {
    private Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != null) {
            ans = Math.min(ans,root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
}
