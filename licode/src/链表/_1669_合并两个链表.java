package 链表;

public class _1669_合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode indexA = list1;
        ListNode indexB = list1;
        while (a != 1) {
            indexA = indexA.next;
            a--;
        }
        // 现在indexA指向了第A个节点的前一个节点

        while (b != -1) {
            indexB = indexB.next;
            b--;
        }
        // 此时indexB指向了第B个节点的下一个节点

        ListNode tail_of_list2 = list2;
        while (tail_of_list2.next != null) {
            tail_of_list2 = tail_of_list2.next;
        }
        indexA.next = list2;
        tail_of_list2.next = indexB;
        return list1;
    }
}
