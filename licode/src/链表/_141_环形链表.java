package 链表;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null && node2.next != null) {
            if (node1 == node2) return true;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return false;
    }
}
