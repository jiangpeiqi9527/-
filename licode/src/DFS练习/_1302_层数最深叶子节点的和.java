package DFS练习;

public class _1302_层数最深叶子节点的和 {
    private Integer maxDepth;
    private Integer sum;
    public int deepestLeavesSum(TreeNode root) {
        maxDepth = 0;
        sum = 0;
        dfs(root,maxDepth,sum);
        return sum;
    }

    private void dfs(TreeNode root, int maxDepth, int sum) {
        if (root == null) return;
        // 这是非叶子节点
        if (root.left != null || root.right != null) {

        }
        // 这是叶子结点
    }
}
