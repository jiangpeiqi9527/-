package 树;

import java.util.LinkedList;
import java.util.Queue;

public class _559_N叉树的最大深度 {
    // 递龟
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 1;
        for (Node child : root.children) {
            max = Math.max(max,maxDepth(child) + 1);
        }
        return max;
    }

    // 迭代 让人想屎
//    public int maxdeep (Node root) {
//        if (root == null) return 0;
//        Queue<Node> queue = new LinkedList<>();
//        int deep = 1;
//        while (!queue.isEmpty()) {
//            Node temp = queue.poll();
//            int currentSize = queue.size();
//            for (int i = 0; i < currentSize; i++) {
//
//            }
//            deep++;
//        }
//        return deep;
//    }
}
