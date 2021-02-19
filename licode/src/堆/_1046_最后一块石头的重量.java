package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while (!pq.isEmpty() && pq.size() != 1) {
            int bigger = pq.poll();
            int smaller = pq.poll();
            if (bigger != smaller) {
                pq.offer(bigger - smaller);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
