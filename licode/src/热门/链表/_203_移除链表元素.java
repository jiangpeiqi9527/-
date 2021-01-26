package 热门.链表;


import java.util.List;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode index1 = tempHead;
        ListNode index2 = head;
        while (index2 != null) {
            if (index2.val == val) {
                index1.next = index2.next;
                index2 = index2.next;
                continue;
            }
            index1 = index1.next;
            index2 = index2.next;
        }
        return tempHead.next;
    }
}
