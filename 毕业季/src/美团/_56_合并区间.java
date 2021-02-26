package 美团;

import java.util.*;

public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Deque<int[]> deque = new LinkedList<>();

        int index = 0;
        int[] temp = null;
        while (index < intervals.length) {
            if (!deque.isEmpty()) {
                temp = deque.peekLast();
                if (temp[1] < intervals[index][0]) {
                    deque.offer(intervals[index]);
                } else {
                    if (temp[1] > intervals[index][1]) {
                        index++;
                        continue;
                    }
                    deque.pollLast();
                    int[] newArr = new int[]{temp[0],intervals[index][1]};
                    deque.offer(newArr);
                }
            } else {
                deque.offer(intervals[index]);
            }
            index++;
        }
        int[][] res = new int[deque.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }
}
