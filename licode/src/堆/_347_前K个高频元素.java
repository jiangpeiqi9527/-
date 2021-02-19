package 堆;

import java.net.Inet4Address;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer i : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(i);
            } else {
                if (map.get(i) > map.get(pq.peek())) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
