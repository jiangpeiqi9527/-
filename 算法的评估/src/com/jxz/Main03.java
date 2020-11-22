package com.jxz;

public class Main03 {
    private TreeNode temp;

  

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            temp = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    public TreeNode nearestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.temp;
    }

}
