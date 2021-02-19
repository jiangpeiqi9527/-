package 链表;

public class _面试题_02_01_移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        boolean[] isExist = new boolean[2001];
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre_head = dummyHead;
        while (head != null) {
            if (isExist[head.val]) { // 这个元素已经存在
                // 需要删除这个元素
                pre_head.next = head.next;
                head = head.next;
            } else { // 这个元素第一次记录
                isExist[head.val] = true;
                head = head.next;
                pre_head = pre_head.next;
            }
        }
        return dummyHead.next;
    }
}
