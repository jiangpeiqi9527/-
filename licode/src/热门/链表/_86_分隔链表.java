package 热门.链表;

public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode vurHead = new ListNode(); // 旧链表的虚拟头结点
        ListNode vurTail = vurHead; // 旧链表的虚拟头结点
        vurHead.next = head;
        ListNode newHead = new ListNode(); // 新链表的头结点
        ListNode newTail = newHead; // 新链表的尾结点

        while (head != null) {
            if (head.val < x) {
                vurTail.next = head.next;
                newTail.next = head;
                ListNode temp = head;
                head = head.next;
                temp.next = null;
                newTail = newTail.next;
                continue;
            }
            head = head.next;
            vurTail = vurTail.next;
        }
        newTail.next = vurHead.next;
        return newHead.next;

    }

    public ListNode partition1(ListNode head, int x) {
        // 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于
        // x 的节点都出现在大于或等于 x 的节点之前。
        ListNode smallNodeHead = new ListNode();
        ListNode vurSmallHead = smallNodeHead;
        ListNode bigNodeHead = new ListNode();
        ListNode vurBigHead = bigNodeHead;
        ListNode vurHead = new ListNode();
        vurHead.next = head;
        ListNode index = head;
        while (index != null) {
            if (index.val < x) {
                vurSmallHead.next = new ListNode(index.val);
                vurSmallHead = vurSmallHead.next;
            } else {
                vurBigHead.next = new ListNode(index.val);
                vurBigHead = vurBigHead.next;
            }
            index = index.next;
        }
        vurSmallHead.next = new ListNode(x);
        vurSmallHead = vurSmallHead.next;
        vurSmallHead.next = bigNodeHead.next;
        return smallNodeHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        // 创建两个链表，一个用于存放小于x的节点，一个用于存放大于x的节点
        ListNode smallNodeHead = new ListNode();
        ListNode vurSmallHead = smallNodeHead;
        ListNode bigNodeHead = new ListNode();
        ListNode vurBigHead = bigNodeHead;
        ListNode vurHead = new ListNode();
        vurHead.next = head;
        ListNode index = head;
        while (index != null) {
            if (index.val < x) {
                vurSmallHead.next = new ListNode(index.val);
                vurSmallHead = vurSmallHead.next;
            }
            if (index.val > x) {
                vurBigHead.next = new ListNode(index.val);
                vurBigHead = vurBigHead.next;
            }
            index = index.next;
        }
        vurSmallHead.next = new ListNode(x);
        vurSmallHead = vurSmallHead.next;
        vurSmallHead.next = bigNodeHead.next;
        return smallNodeHead.next;
    }
}
