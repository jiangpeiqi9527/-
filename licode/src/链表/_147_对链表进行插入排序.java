package 链表;

public class _147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        while (curr != null) {
            if (pre.val <= curr.val) {
                curr = curr.next;
                pre = pre.next;
            } else {
                ListNode node = dummyHead;
                while (node.next != null) {
                    if (node.next.val > curr.val) {
                        ListNode temp = curr;
                        curr = curr.next;
                        pre.next = curr;
                        temp.next = node.next;
                        node.next = temp;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        return dummyHead.next;
    }
}
