package 树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _589_N叉树的前序遍历 {
    // 递龟
    //-----------------------
//    private List<Integer> res;
//    public List<Integer> preorder(Node root) {
//        res = new LinkedList<>();
//        solution(root,res);
//        return res;
//    }
//
//    private void solution(Node root, List<Integer> res) {
//        if (root == null) return;
//        res.add(root.val);
//        List<Node> childrens = root.children;
//        for (Node node : childrens) {
//            solution(node,res);
//        }
//    }
    //-----------------------

    // 迭代
    //-----------------------
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.push(item);
            }
        }
        return output;


    }
    //-----------------------


}
