package com.jxz.Trie前缀树;

import java.time.temporal.ValueRange;
import java.util.HashMap;

public class Trie<V> {

    private Node<V> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public V get (String key) {
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }

    public boolean contains(String key) {
        return node(key) != null;
    }

    public V add(String key,V value) {
        keyCheck(key);

        // 判断根节点是否为空
        if (root == null) {
            root = new Node<>();
        }
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> newNode = emptyChildren ? null : node.children.get(c);
            if (newNode == null) {
                newNode = new Node<>();
                node.children = emptyChildren ? new HashMap<>() : node.children;
                node.children.put(c,newNode);
            }
            node = newNode;
        }
        if (node.word) { // 已经存在这个单词
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        // 新增一个单词
        node.word = true;
        node.value = value;
        size++;
        return null;
    }

    public V remove(String str) {
return null;
    }

    /**
     * 用于找前缀的
     * @param prefix
     * @return
     */
    public boolean starsWith(String prefix) {
        keyCheck(prefix);
        Node<V> node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) return false;
            char c = prefix.charAt(i);
            node = node.children.get(c);
        }
        return true;
    }

    /**
     * 用来找单词的节点
     * @param key 我想找什么单词
     * @return 有就返回，没有就返回null
     */
    private Node<V> node (String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) return null;
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node.word ? node : null;
    }

    private void keyCheck (String key) {
        if (key == null || key.length() == 0) throw new IllegalArgumentException("key must not be empty");
    }

    private static class Node<V> {
        HashMap<Character,Node<V>> children;
        V value;
        boolean word; // 是否为一个单词的结尾（是否为一个完整的单词）
//        public HashMap<Character,Node<V>> getChildren () {
//            return children == null ? (children = new HashMap<>()) : children;
//        }
    }


}