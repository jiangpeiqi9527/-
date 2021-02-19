package 链表;

import java.util.Stack;

public class _445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode dummyHead = new ListNode();
        if (stack1.size() < stack2.size()) {
            Stack<ListNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        // 此时stack1是元素较多的一个
        int jinwei = 0;
        int sum = 0;
        while (!stack2.isEmpty()) {
            sum = stack1.pop().val + stack2.pop().val + jinwei;
            jinwei = sum / 10;
            ListNode node = new ListNode(sum % 10, dummyHead.next);
            dummyHead.next = node;
        }
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                sum = stack1.pop().val + jinwei;
                jinwei = sum / 10;
                ListNode node = new ListNode(sum % 10, dummyHead.next);
                dummyHead.next = node;
            }
            if (jinwei != 0) {
                ListNode node = new ListNode(jinwei, dummyHead.next);
                dummyHead.next = node;
            }
        } else if (jinwei != 0) {
            ListNode node = new ListNode(jinwei, dummyHead.next);
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
