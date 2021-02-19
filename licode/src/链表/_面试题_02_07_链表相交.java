package 链表;



public class _面试题_02_07_链表相交 {
    public ListNode getIntersectionNode(链表.ListNode headA, 链表.ListNode headB) {
        int countA = getListNodeCount(headA);
        int countB = getListNodeCount(headB);
        if (countB > countA) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        // 此时HeadA是长链表
        int needStep = Math.abs(countA - countB);
        while (needStep != 0) {
            needStep--;
            headA = headA.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getListNodeCount(ListNode node) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = node;
        ListNode index = dummyHead;
        int count = 0;
        while (index.next != null) {
            index = index.next;
            count++;
        }
        return count;
    }

//    public static void main(String[] args) {
//        链表.ListNode head = new ListNode(4);
//        head.next = new ListNode(1);
//
//        链表.ListNode head2 = new ListNode(5);
//        head2.next = new ListNode(0);
//        head2.next.next = new ListNode(1);
//
//        ListNode together = new ListNode(8);
//        together.next = new ListNode(4);
//        together.next.next = new ListNode(5);
//        head.next.next = together;
//        head2.next.next.next = together;
//
//
//        _面试题_02_07_链表相交  o = new _面试题_02_07_链表相交();
//        o.getIntersectionNode(head, head2);
//    }

}


