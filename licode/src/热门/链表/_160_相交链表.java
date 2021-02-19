package 热门.链表;

import java.util.logging.Logger;

public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        ListNode index = headA;
        while (index != null) {
            countA++;
            index = index.next;
        }

        int countB = 0;
        index = headB;
        while (index != null) {
            countB++;
            index = index.next;
        }

        int diff = Math.abs(countA - countB);
        ListNode longgerlist = countA >= countB ? headA : headB;
        ListNode shorterList = longgerlist == headA ? headB : headA;
        while (diff > 0) {
            diff--;
            longgerlist = longgerlist.next;
        }

        while (longgerlist != null && shorterList != null) {
            if (longgerlist.next == shorterList.next) {
                return longgerlist.next;
            }
            longgerlist = longgerlist.next;
            shorterList = shorterList.next;
        }
        return null;
    }

}

