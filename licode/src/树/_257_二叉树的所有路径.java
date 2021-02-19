package 树;

import java.util.ArrayList;
import java.util.List;

public class _257_二叉树的所有路径 {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(root,"");
        return list;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) return;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(path + root.val);
        if (root.left == null && root.right == null) {

            list.add(sb1.toString());
            return;
        }
            sb1.append("->");
            dfs(root.left,sb1.toString());

            dfs(root.right,sb1.toString());


    }

    public static void main(String[] args) {
        _257_二叉树的所有路径 o = new _257_二叉树的所有路径();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);

        root.left = root1;
        root.right = root2;
        root1.right = root3;

        List<String> strings = o.binaryTreePaths(root);
        System.out.println(strings);
    }
}
