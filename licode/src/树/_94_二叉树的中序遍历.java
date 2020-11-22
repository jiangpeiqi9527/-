package 树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
    private List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return Arrays.asList();
        inorderTraversal1(root.left);
        list.add(root.val);
        inorderTraversal1(root.right);
        return list;
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
                TreeNode temp = stack.pop();
                res.add(temp.val);
                root = temp.right;
            }
        }
        return res;
    }
}
