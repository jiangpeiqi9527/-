package com.jxz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int find (TreeNode root) {
        // write code here
    if (root == null) throw new RuntimeException("error");
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<TreeNode> list = new LinkedList<>();
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        list.add(node);
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
    }
    TreeNode lastNode = list.get(list.size() - 1);
    int res = lastNode.val;
    return res;
    }
}
