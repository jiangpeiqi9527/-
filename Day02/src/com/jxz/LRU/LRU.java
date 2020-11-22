package com.jxz.LRU;


import java.util.HashMap;
import java.util.Map;

public class LRU {
    int capacity;
    Map<Integer, LinkNode> map = new HashMap<>();
    LinkNode head = new LinkNode(0, 0);
    LinkNode tail = new LinkNode(0, 0);

    public LRU(int cap) {
        this.capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            moveNodeToTop(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) deleteLastNode();
            LinkNode temp = head.next;
            LinkNode newNode = new LinkNode(key, value);
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
            map.put(key, newNode);
        } else {
            LinkNode node = map.get(key);
            node.value = value;
            moveNodeToTop(node);
        }
    }


    private void deleteLastNode() {
        LinkNode lastNode = tail.prev;
        tail.prev = lastNode.prev;
        tail.prev.next = tail;
        map.remove(lastNode.key);
    }

    private void moveNodeToTop(LinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        LinkNode firstNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = firstNode;
        firstNode.prev = node;
    }

}

class LinkNode {
    int key;
    int value;
    LinkNode prev;
    LinkNode next;

    public LinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}