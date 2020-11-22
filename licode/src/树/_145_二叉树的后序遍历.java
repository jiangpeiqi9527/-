package 树;

import java.util.LinkedList;
import java.util.List;

public class _145_二叉树的后序遍历 {
    private List<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        solution(root,list);
        return list;
    }

    private void solution(TreeNode root, List<Integer> list) {
        if (root == null) return;
        solution(root.left,list);
        solution(root.right,list);
        list.add(root.val);
    }
}
