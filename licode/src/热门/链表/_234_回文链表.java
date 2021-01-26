package 热门.链表;

public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        // 两个链表，头插法、尾插法
        int count = 0;
        ListNode countIndex = head;
        while (countIndex != null) {
            count++;
            countIndex = countIndex.next;
        }
        int mid_add_one = (count >> 1) + 1;
        ListNode partOneHead = new ListNode();
        ListNode partOneTail = partOneHead;


        ListNode partTwoHead = new ListNode();

        ListNode midIndex = head;
        while (mid_add_one > 1) {
            midIndex = midIndex.next;
            mid_add_one--;
        }

        while (midIndex != null) {
            ListNode temp = head;
            head = head.next;
            partOneTail.next = temp;
            partOneTail = partOneTail.next;

            temp = midIndex;
            midIndex = midIndex.next;
            temp.next = partTwoHead.next;
            partTwoHead.next = temp;
        }

        while (partTwoHead != null) {
            if (partOneHead.val != partTwoHead.val) return false;
            partOneHead = partOneHead.next;
            partTwoHead = partTwoHead.next;
        }
        return true;
    }
}
