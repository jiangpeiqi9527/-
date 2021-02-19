package 链表;

public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode circleNode = getCircle(head);
        if (circleNode == null) return null;
        ListNode part2 = circleNode.next;
        circleNode.next = null;
        ListNode togetherNode = getIntersectionNode(head, part2);
        return togetherNode;
    }

    private ListNode getCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return slow;
        }
        return null;
    }

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
}
