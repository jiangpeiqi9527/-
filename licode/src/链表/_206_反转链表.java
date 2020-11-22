package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode newhead = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;

    }
}
