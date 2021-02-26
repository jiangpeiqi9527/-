package 美团;

import 链表.ListNode;

public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode();

        while (head != null) {
            ListNode temp = head;
            head = head.next;

            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        return dummyHead.next;
    }
}
