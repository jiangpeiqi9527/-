package 热门;

import java.util.HashMap;

public class _146_LRU缓存机制 {
    class LRUCache {

        private int capacity;

        private HashMap<Integer, Node> map;

        private Node head = new Node();

        private Node tail = new Node();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                moveToFirst(key);
                return map.get(key).value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).value = value;
                moveToFirst(key);
            } else {
                if (map.size() == capacity) {
                    deleteLastElement();
                }
                Node node = new Node(key, value);
                map.put(key, node);
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;

            }
        }

        private void deleteLastElement() {
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }

        private void moveToFirst(int key) {
            // 找到这个node
            Node node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;

            // 把这个node移动到head节点之后
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        class Node {
            Integer key;
            Integer value;
            Node prev;
            Node next;

            public Node(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public Node() {
            }
        }
    }
}
