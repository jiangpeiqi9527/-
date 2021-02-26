package 美团;

import 链表.ListNode;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        int jinwei = 0;
        int sum;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + jinwei;
            jinwei = sum / 10; //
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        l1 = l1 != null ? l1 : l2;
        if (l1 == null) {
            return dummyHead.next;
        }

        while (l1 != null) {
            sum = l1.val + jinwei;
            jinwei = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = l1.next;
        }

        if (jinwei != 0) {
            tail.next = new ListNode(jinwei);
            tail = tail.next;
        }

        return dummyHead.next;
    }
}
