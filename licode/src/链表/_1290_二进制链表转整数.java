package 链表;

import 热门.链表.ListNode;

public class _1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
}
