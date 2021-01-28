package 热门.链表;

public class _21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode temp = l1;

                l1 = l1.next;
                newTail.next = temp;
                temp.next = null;
                newTail = newTail.next;
                continue;
            }
            if (l2.val <= l1.val) {
                ListNode temp = l2;

                l2 = l2.next;
                newTail.next = temp;
                temp.next = null;
                newTail = newTail.next;
                continue;
            }
        }
        newTail.next = l1 != null ? l1 : l2;
        return newHead.next;
    }
}
