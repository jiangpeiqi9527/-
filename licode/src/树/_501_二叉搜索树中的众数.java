package 树;

import java.util.*;

public class _501_二叉搜索树中的众数 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Integer key : map.keySet()) {
            pq.offer(key);
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Integer value = pq.poll();
            res.add(value);
            if (map.get(value) != map.get(pq.peek())) {
                break;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }
}
