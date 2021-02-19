package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _剑指_Offer_40_最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(4, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i = (Integer) o2 - (Integer) o1;
                return i;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
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
            if (!pq.isEmpty() && pq.peek() > arr[i]) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
