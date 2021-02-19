package 链表;

public class _19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vurHead = new ListNode(0);
        vurHead.next = head;
        ListNode index1 = head;
        while (n != 0) {
            index1 = index1.next;
            n--;
        }
        ListNode index2 = head;
        ListNode vurindex2 = new ListNode(0);
        vurindex2.next = index2;
        while (index1 != null) {
            index1 = index1.next;
            index2 = index2.next;
            vurindex2 = vurindex2.next;
        }
        // 删除这个index2节点
        vurindex2.next = index2.next;
        return vurHead.next;
    }
}
