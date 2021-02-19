package 链表;

public class _1721_交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        int n1 = k;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode index = dummyHead;
        while (n1 != 0) {
            index = index.next;
            n1--;
        }
        ListNode index2 = dummyHead;
        ListNode temp = index;
        while (temp != null) {
            temp = temp.next;
            index2 = index2.next;
        }
        // 交换两个元素
        int i = index.val;
        index.val = index2.val;
        index2.val = i;
        return dummyHead.next;
    }
}
