package 树;

public class _450_删除二叉搜索树中的节点 {
    // 后继
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // 前驱
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) { // 如果是叶子结点直接删除
                root = null;
            } else if (root.right != null) { // 右节点不为空，找后继
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else { // 左节点不为空，找前驱
                root.val = predecessor(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }
}
