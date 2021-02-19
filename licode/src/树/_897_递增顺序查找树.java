package 树;

public class _897_递增顺序查找树 {
    TreeNode ans = new TreeNode(0);
    TreeNode cur = ans;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        increasingBST(root.right);
        return ans.right;
    }
}
