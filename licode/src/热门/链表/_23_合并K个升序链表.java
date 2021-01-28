package 热门.链表;

import java.util.*;

public class _23_合并K个升序链表 {
    // 使用优先队列
    public ListNode pqmergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length < 1) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            pq.offer(lists[i]);
        }
        while (pq.size() != 1) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        curr.next = pq.poll();
        return dummyHead;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length < 1) return null;
        int count = lists.length;
        boolean[] isNull = new boolean[lists.length];
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;

        while (count != 1) {
            int index = 0;
            for (int i = 0; i < isNull.length; i++) {
                if (!isNull[i]) {
                    index = i;
                    break;
                }
            }
            ListNode minNode = lists[index];
            for (int i = index + 1; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (minNode.val > lists[i].val) {
                    minNode = lists[i];
                    index = i;
                }
            }

            lists[index] = minNode.next;
            newTail.next = minNode;
            minNode.next = null;
            newTail = newTail.next;
            if (lists[index] == null) {
                count--;
                isNull[index] = true;
            }
        }
        int index = 0;
        for (int i = 0; i < isNull.length; i++) {
            if (!isNull[i]) {
                index = i;
                break;
            }
        }
        newTail.next = lists[index];
        return newHead.next;
    }

    // 正确但是超出时间范围
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length < 1) return null;
        List<ListNode> headNodes = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            headNodes.add(lists[i]);
        }
        if (headNodes.isEmpty()) return null;
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;

        while (!headNodes.isEmpty() && headNodes.size() != 1) {
            ListNode minNode = headNodes.get(0);
            if (minNode == null) return null;
            int index = 0;
            for (int i = 0; i < headNodes.size(); i++) {
                if (minNode.val > headNodes.get(i).val) {
                    minNode = headNodes.get(i);
                    index = i;
                }
            }
            headNodes.remove(index);
            headNodes.add(index, minNode.next);
            newTail.next = minNode;
            minNode.next = null;
            newTail = newTail.next;
            if (headNodes.get(index) == null) {
                headNodes.remove(index);
            }
        }
        newTail.next = headNodes.get(0);
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        _23_合并K个升序链表 test = new _23_合并K个升序链表();
        ListNode listNode = test.mergeKLists(new ListNode[]{root1, root2, root3});
    }
}
