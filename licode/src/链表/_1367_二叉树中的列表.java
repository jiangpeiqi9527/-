package 链表;

public class _1367_二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    private boolean dfs(TreeNode rt, ListNode head) {
        if (head == null) return true;
        if (rt == null) return false;
        if (rt.val != head.val) return false;
        return dfs(rt.left, head.next) || dfs(rt.right, head.next);

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
