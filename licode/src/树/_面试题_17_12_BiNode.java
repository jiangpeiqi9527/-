package 树;

public class _面试题_17_12_BiNode {
    private TreeNode dummyHead = new TreeNode(0);
    private TreeNode rightNode = dummyHead;
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return dummyHead.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        rightNode.right = root;
        root.left = null;
        rightNode = rightNode.right;
        inorder(root.right);
    }
}
