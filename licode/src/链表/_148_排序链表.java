package 链表;


import java.util.Comparator;
import java.util.PriorityQueue;

public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
        ListNode tail = dummyHead;
        while (head != null) {
            pq.offer(head);
            head = head.next;
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            tail.next = temp;
            temp.next = null;
            tail = tail.next;
        }
        return dummyHead.next;
    }
}
