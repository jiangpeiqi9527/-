package 链表;

import java.util.HashMap;
import java.util.Map;

public class _剑指_Offer_35_复杂链表的复制 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node index = head;
        while (index != null) {
            map.put(index, new Node(index.val));
            index = index.next;
        }
        index = head;
        while (index != null) {
            map.get(index).next = map.get(index.next);
            map.get(index).random = map.get(index.random);
            index = index.next;
        }

        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}