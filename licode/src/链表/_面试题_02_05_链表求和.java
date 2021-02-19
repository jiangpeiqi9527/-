package 链表;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _面试题_02_05_链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> stack1 = new LinkedList<>();
        Queue<ListNode> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.offer(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offer(l2);
            l2 = l2.next;
        }
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        if (stack1.size() < stack2.size()) {
            Queue<ListNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        // 此时stack1是元素较多的一个
        int jinwei = 0;
        int sum = 0;
        while (!stack2.isEmpty()) {
            sum = stack1.poll().val + stack2.poll().val + jinwei;
            jinwei = sum / 10;
            ListNode node = new ListNode(sum % 10, tail.next);
            tail.next = node;
            tail = tail.next;
        }
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                sum = stack1.poll().val + jinwei;
                jinwei = sum / 10;
                ListNode node = new ListNode(sum % 10, tail.next);
                tail.next = node;
                tail = tail.next;
            }
            if (jinwei != 0) {
                ListNode node = new ListNode(jinwei,  tail.next);
                tail.next = node;
                tail = tail.next;
            }
        } else if (jinwei != 0) {
            ListNode node = new ListNode(jinwei,  tail.next);
            tail.next = node;
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        _面试题_02_05_链表求和 o = new _面试题_02_05_链表求和();
        ListNode head1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode head2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        o.addTwoNumbers(head1,head2);
    }
}
