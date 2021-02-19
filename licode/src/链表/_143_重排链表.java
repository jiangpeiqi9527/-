package 链表;

import java.util.Stack;

public class _143_重排链表 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 找到中间节点(如果是偶数节点则为靠前的节点)
        ListNode midNode = getMidNode(head);
        ListNode index = midNode.next;
        Stack<ListNode> stack = new Stack<>();
        while (index != null) {
            stack.push(index);
            index = index.next;
        }
        midNode.next = null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode index2 = null;
        while (head != null && !stack.isEmpty()) {
            index = head;
            head = head.next;
            index2 = stack.pop();
            index2.next = index.next;
            index.next = index2;
        }
    }

    private ListNode getMidNode(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fastNode = dummyHead;
        ListNode slowNode = dummyHead;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
