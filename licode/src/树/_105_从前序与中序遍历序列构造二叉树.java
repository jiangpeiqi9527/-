package 树;

import org.junit.Test;

import java.util.HashMap;

public class _105_从前序与中序遍历序列构造二叉树 {
    //    public TreeNode buildTree(int[] preorder, int[] inorder) {
//       return treeFactory(preorder,0,preorder.length,inorder,0,inorder.length);
//    }
//
//    private TreeNode treeFactory(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
//        if (p_start == p_end) return null;
//        TreeNode node = new TreeNode(preorder[p_start]);
//        int nodeVal = preorder[p_start];
//        int i_root_val_index = 0;
//        for (int i = i_start; i < i_end; i++) {
//            if (nodeVal == inorder[i]) {
//                i_root_val_index = i;
//                break;
//            }
//        }
//        int leftNums = i_root_val_index - i_start;
//        node.left = treeFactory(preorder,p_start + 1,p_start + 1 + leftNums,inorder,i_start,i_root_val_index);
//        node.right = treeFactory(preorder,p_start + 1 + leftNums,p_end,inorder,i_root_val_index + 1,i_end);
//        return node;
//    }
    // 改进，使用map集合来存储inorder数组的数字和下标

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i : inorder) {
            map.put(i,index++);
        }
        return treeFactory(preorder, 0, preorder.length, inorder, 0, inorder.length,map);
    }

    private TreeNode treeFactory(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start == p_end) return null;
        int nodeVal = preorder[p_start];
        TreeNode node = new TreeNode(preorder[p_start]);
        int i_root_val_index = map.get(nodeVal);
        int leftNums = i_root_val_index - i_start;
        node.left = treeFactory(preorder,p_start + 1,p_start + 1 + leftNums,inorder,i_start,i_root_val_index,map);
        node.right = treeFactory(preorder,p_start + 1 + leftNums,p_end,inorder,i_root_val_index + 1,i_end,map);
        return node;
    }

    @Test
    public void test () {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

}
