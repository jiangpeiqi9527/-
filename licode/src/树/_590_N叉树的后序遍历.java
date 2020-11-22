package 树;

import java.util.LinkedList;
import java.util.List;

public class _590_N叉树的后序遍历 {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new LinkedList<>();
        solution(root,res);
        if (root != null) {
            res.add(root.val);
        }
        return res;
    }

    private void solution(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            solution(child,res);
            res.add(child.val);
        }
    }
}
