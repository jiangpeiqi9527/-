package 树;

import org.junit.Test;

import java.util.HashMap;

public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i : inorder) {
            map.put(i,index++);
        }
        return treeFactory(postorder,-1,postorder.length - 1,inorder,0,inorder.length,map);
    }
    // 太难了，爷不做辣
    // 规定：后序遍历的右边界指向当前头结点，左边界指向XX子树的前一个节点，这样方便做跳出。中序遍历的左边界指向XX子树的第一个节点，右边界指向XX子树的后一个节点。
    private TreeNode treeFactory(int[] postorder, int p_left, int p_right, int[] inorder, int i_left, int i_right, HashMap<Integer, Integer> map) {
        if (p_left == p_right) return null;
        TreeNode node = new TreeNode(postorder[p_right]);
        int nodeVal = postorder[p_right];
        int i_root_val_index = map.get(nodeVal);
        int rightNums = i_right - 1 - i_root_val_index;
        node.left = treeFactory(postorder,p_left,p_right - 1 - rightNums,inorder,i_left,i_root_val_index,map);
        node.right = treeFactory(postorder,p_right - 1 - rightNums,p_right - 1,inorder,i_root_val_index + 1,i_right,map);
        return node;
    }
    @Test
    public void test () {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
