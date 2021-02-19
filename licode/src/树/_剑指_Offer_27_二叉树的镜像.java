package 树;

public class _剑指_Offer_27_二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode newRoot = reverse(root);
        return newRoot;
    }

    private TreeNode reverse(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
        return root;
    }
}
