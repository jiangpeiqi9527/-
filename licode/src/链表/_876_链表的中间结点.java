package 链表;

public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null || head.next.next == null) return (head.next == null ? head : head.next);
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return node1;
    }
}
