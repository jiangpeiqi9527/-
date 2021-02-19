package 链表;

import java.util.ArrayList;
import java.util.List;

public class _1019_链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] arr = list.toArray(new Integer[]{});
        Integer[] dp = new Integer[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                dp[i] = arr[i + 1];
            } else {
                int j = i;
                while (j < dp.length - 1) {
                    if (arr[i] < dp[j + 1]) {
                        dp[i] = dp[j + 1];
                        break;
                    }
                    j++;
                }
            }
        }
        int[] res = new int[dp.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[i];
        }
        return res;
    }
}
