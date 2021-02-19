package 树;

import 链表.Test;

public class _剑指_Offer_68__I_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        return leftNode != null ? (rightNode != null ? root : leftNode) : (rightNode != null ? rightNode : null);
    }
}
