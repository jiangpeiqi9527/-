package 树;

public class _606_根据二叉树创建字符串 {
    public String tree2str(TreeNode t) {
        if (t == null) return null;
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
