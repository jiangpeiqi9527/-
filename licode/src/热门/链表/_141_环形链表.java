package 热门.链表;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) return true;
        }
        return false;
    }
}
