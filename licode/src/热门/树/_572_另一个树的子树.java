package 热门.树;

public class _572_另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = postSerializable(s);
        String tree2 = postSerializable(t);

        return tree1.contains(tree2);
    }

    private String postSerializable(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        postSerializable(t,sb);
        return sb.toString();
    }

    private void postSerializable(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append("#");
            return;
        }
        postSerializable(t.left,sb);
        postSerializable(t.right,sb);
        sb.append(t.val).append("!");
    }

}
