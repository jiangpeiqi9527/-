package 链表;

import 热门.链表.ListNode;

public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode utilNode = dummyHead;
        while (k != 0) {
            k--;
            if (utilNode.next == null) {
                utilNode = head;
                continue;
            }
            utilNode = utilNode.next;
        }
        ListNode startNode = dummyHead;
        ListNode dummyStartNode = new ListNode(0);
        dummyHead.next = startNode;
        while (utilNode != null) {
            utilNode = utilNode.next;
            startNode = startNode.next;
            dummyStartNode = dummyStartNode.next;
        }
        ListNode newDummyHead = new ListNode(0);
        ListNode newTail = newDummyHead;
        newDummyHead.next = startNode;
        dummyStartNode.next = null;
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        newTail.next = dummyHead.next;
        return newDummyHead.next;
    }
}
