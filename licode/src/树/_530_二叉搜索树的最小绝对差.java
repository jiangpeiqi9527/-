package 树;

import java.util.ArrayList;
import java.util.List;

public class _530_二叉搜索树的最小绝对差 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int minAbs = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int num = Math.abs(list.get(i) - list.get(i - 1));
            minAbs = Math.min(minAbs,num);
        }
        return minAbs;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
