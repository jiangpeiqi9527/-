package 链表;

public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode part2 = new ListNode();
        ListNode part2Tail = part2;
        boolean remove = false;
        while (head != null) {
            if (remove) {
                ListNode temp = head;
                head = head.next;
                remove = false;
                pre.next = head;
                part2Tail.next = temp;
                temp.next = null;
                part2Tail = part2Tail.next;
            } else {
                head = head.next;
                pre = pre.next;
                remove = true;
            }
        }
        pre.next = part2.next;
        return dummyHead.next;
    }
}
