package 热门.树;

import java.util.HashMap;
import java.util.Map;

public class _105_从前序与中序遍历序列构造二叉树 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inorderLeft, int inorderRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorder_root = map.get(preorder[preLeft]);
        int size_left_tree = inorder_root - inorderLeft;
        root.left = myBuildTree(preorder,inorder,preLeft + 1,preLeft + size_left_tree,inorderLeft,inorder_root - 1);
        root.right = myBuildTree(preorder,inorder,preLeft + size_left_tree + 1,preRight,inorder_root + 1,inorderRight);
        return root;
    }


}
