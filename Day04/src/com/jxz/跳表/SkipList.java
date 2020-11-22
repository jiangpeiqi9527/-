package com.jxz.跳表;

import java.util.Comparator;

public class SkipList<K,V> {
    /**
     * redis的SortedSet的底层使用了跳表，最高的这个，嗯，节点数组大小为32
     */
    private static final int MAX_LEVEL = 32;

    private static final double P = 0.25;
    /**
     * 有效层数
     */
    private int level;
    private int size;
    private Comparator<K> comparator;
    /**
     * 不存放任何 K-V
     */
    private Node<K,V> first;

    public SkipList (Comparator<K> comparator) {
        this.comparator = comparator;
        this.first = new Node<>(null,null,MAX_LEVEL);
        first.nexts = new Node[MAX_LEVEL];
    }

    private void keyCheck (K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
    }
    private int compare (K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                : ((Comparable<K>)k1).compareTo(k2);
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public V put (K key, V value) {
        keyCheck(key);
        Node<K,V> node = first;
        Node<K,V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) { // 节点存在
                V oldValue = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldValue;
            }
            prevs[i] = node;
        }

        // 新节点的层数
        int newLevel = randomLevel();
        // 添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        // 设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i] = newNode;
            }
        }

        // 节点数量增加
        size++;

        // 计算跳表的最终层数
        this.level = Math.max(level, newLevel);
        return null;
    }

    /**
     * 给节点一个随机层数
     * @return
     */
    private int randomLevel () {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public V get (K key) {
        keyCheck(key);
        Node<K,V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) return node.nexts[i].value;
        }
        return null;
    }

    public V remove (K key) {
        keyCheck(key);
        return null;
    }

    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }
    }
}
