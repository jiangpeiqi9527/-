package 热门.链表;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode();
        ListNode tempTail = tempHead;
        tempHead.next = tempTail;
        int carry = 0; // 进位值
        while (l1 != null || l2 != null) {

            int num1 = l1 == null ? 0 : l1.val;

            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + carry;

            // 设置进位值
            carry = sum / 10;

            tempTail.next = new ListNode(sum % 10);
            tempTail = tempTail.next;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;
        }

        // 检查最后的进位
        if (carry > 0) {
            tempTail.next = new ListNode(carry);
        }
        return tempHead.next;
    }
}
