package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _面试题_17_14_最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
