package 树;

import java.util.ArrayList;
import java.util.List;

public class _872_叶子相似的树 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1,list1);
        dfs(root2,list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                // 这是叶子节点
                list.add(root.val);
                return;
            }
            dfs(root.left,list);
            dfs(root.right,list);
        }
    }
}
