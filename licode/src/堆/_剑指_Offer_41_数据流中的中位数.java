package 堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _剑指_Offer_41_数据流中的中位数 {


    PriorityQueue<Integer> pqSmall; // 小顶堆，用于存放数组中较大的一半元素
    PriorityQueue<Integer> pqBig; // 大顶堆，用于存放数组中较小的一半元素
    boolean flag; // flag = true 表示现在有奇数个元素，false表示现在有偶数个元素

    /**
     * initialize your data structure here.
     */
    public _剑指_Offer_41_数据流中的中位数() {
        pqSmall = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pqBig = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (flag) {
            pqSmall.offer(num);
            pqBig.offer(pqSmall.poll());
            flag = false;
        } else {
            pqBig.offer(num);
            pqSmall.offer(pqBig.poll());
            flag = true;
        }
    }

    public double findMedian() {
        return flag ? pqSmall.peek() : (pqSmall.peek() + pqBig.peek()) / 2.0;
    }
}
