package 热门.队列;

import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int ri = 0; ri < nums.length - k + 1; ri++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[ri]) {
                deque.pollLast();
            }
            deque.offerLast(ri);
            int li = ri - k + 1;
            if (li < 0) continue;

            // 检查是否在窗口内
            if (li > deque.peekFirst()) {
                deque.pollFirst();
            }
            maxes[li] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
