package 链表;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}
