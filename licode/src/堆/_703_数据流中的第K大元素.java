package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _703_数据流中的第K大元素 {
    private PriorityQueue<Integer> pq;
    private int initSize;

    public _703_数据流中的第K大元素(int k, int[] nums) {
        initSize = k;
        pq = new PriorityQueue<>(initSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (pq.size() == initSize) {
            if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
        } else {
            pq.offer(val);
        }
        return pq.peek();
    }
}
