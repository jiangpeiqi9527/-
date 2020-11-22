package 链表;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null || head.next == null) return head.val == val ? null : head;
        ListNode temp = head;
        if (temp.val == val) {
            head = head.next;
            return head;
        }
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
