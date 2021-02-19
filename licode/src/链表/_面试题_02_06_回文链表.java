package 链表;

public class _面试题_02_06_回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode part2 = getPart2(head);
        ListNode part2Head = new ListNode();
        while (part2 != null) {
            ListNode temp = part2;
            part2 = part2.next;
            temp.next = part2Head.next;
            part2Head.next = temp;
        }
        part2Head = part2Head.next;
        while (part2Head != null) {
            if (part2Head.val != head.val) return false;
            part2Head = part2Head.next;
            head = head.next;
        }
        return true;
    }

    private ListNode getPart2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == null ? slow : slow.next;
    }
}
