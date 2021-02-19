package 链表;

public class _92_反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode indexM = head;
        ListNode preM = dummyHead;
        int diff = n - m;
        while (m != 1) {
            m--;
            preM = preM.next;
            indexM = indexM.next;
        }
        ListNode part2 = new ListNode();
        ListNode tail2 = indexM;
        while (diff != 0) {
            ListNode temp = indexM;
            indexM = indexM.next;
            preM.next = indexM;
            temp.next = part2.next;
            part2.next = temp;
            diff--;
        }
        preM.next = part2.next;
        tail2.next = indexM;
        return dummyHead.next;
    }
}
