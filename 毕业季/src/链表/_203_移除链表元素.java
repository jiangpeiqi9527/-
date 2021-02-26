package 链表;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }


}
