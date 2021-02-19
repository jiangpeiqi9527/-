package 链表;

import 热门.链表.ListNode;

public class _剑指_Offer_24_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode temp = null;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
