package 链表;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode index = head;
        while (index != null && index.next != null) {
            if (index.val == index.next.val) {
                index.next = index.next.next;
                continue;
            }
            index = index.next;
        }
        return head;
    }
}
