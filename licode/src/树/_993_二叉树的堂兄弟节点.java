package 树;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class _993_二叉树的堂兄弟节点 {
    private Map<Integer,Integer> depth = new HashMap<>();
    private Map<Integer,TreeNode> prev = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null);
        return depth.get(x) == depth.get(y) && prev.get(x) != prev.get(y);
    }
    private void dfs(TreeNode root, TreeNode prevNode) {
        if (root == null) return;
        depth.put(root.val,prevNode != null ? depth.get(prevNode) + 1 : 0);
        if (prevNode != null) {
            prev.put(root.val,prevNode);
        }
        dfs(root.left,root);
        dfs(root.right,root);
    }

}
