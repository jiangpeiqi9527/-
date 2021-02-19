package 链表;

public class _剑指_Offer_22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fastNode = head;
        while (k != 0) {
            k--;
            fastNode = fastNode.next;
        }
        ListNode slowNode = head;
        ListNode dummySlow = dummyHead;
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            dummySlow = dummyHead.next;
        }
        // 删除slowNode这个节点
        dummySlow.next = slowNode.next;
        return dummyHead.next;
    }
}
