package 树;

public class _230_二叉搜索树中第K小的元素 {
    private int res;
    private int count = 1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (count == k) {
            res = root.val;
            return;
        }
        count++;
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        _230_二叉搜索树中第K小的元素 o = new _230_二叉搜索树中第K小的元素();
        o.kthSmallest(TreeNode.string2Tree(new Integer[]{3,1,4,null,2}),1);
    }
}
