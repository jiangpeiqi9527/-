package 热门.链表;

public class _206_反转链表 {
    // 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    // 迭代
    public ListNode reverseList2(ListNode head) {
        ListNode vurHead = new ListNode();
        ListNode temp = head;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = vurHead.next;
            vurHead.next = temp;
        }
        return vurHead.next;
    }
}
