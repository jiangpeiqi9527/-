package com.jxz.二叉搜索树;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree (Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {

            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.left;
            } else if (cmp < 0) {
                node = node.right;
            } else { // 相等
                node.element = element;
                return;
            }
        }
        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element,parent);
        if (cmp > 0) {
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove (Node<E> node) {
        if (node == null) return;

        size--;

        if (node.hasTowChildren()) { // 度为2的节点
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继
            node = s; // 为了后面删除节点的统一操作
        }
        // 删除node节点 （node的度必为 1 或 0）
        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null) { // node为度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的指向
            if (node.parent == null) {
                root = replacement;
            }else if (node == node.parent.left) {
                node.parent.left = replacement;
            }else if (node == node.parent.right){
                node.parent.right = replacement;

            }
        } else if (node.parent == null) { // node是度为0，并且是根节点
            root = null;
        }else { // node是度为0的叶子节点
            if (node == node.parent.left) {
                node.parent.left = null;
            }else  {
                node.parent.right = null;
            }
        }

    }

    private Node<E> predecessor (Node<E> node) {
        if (node == null) return null;
        // 前驱节点在左子树中
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
    private Node<E> successor(Node<E> node) {
        if (node == null) return null;
        // 后继节点在右子树中
        Node<E> s = node.right;
        if (s != null) {
            while (s.left != null) {
                s = s.left;
            }
            return s;
        }

        // 后继节点在父节点、祖父节点中寻找
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    private Node<E> node (E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element,node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    // 判断是否是完全二叉树
    public boolean isComplete() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) { // node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else { // node.right == null
                leaf = true;
            }
        }

        return true;
    }

    // 计算高度
    public int height3 () {
        if (root == null) return 0;
        // 树的高度
        int height = 0;
        // 每一层的元素数量
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) { // 意味着即将访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    public int height1 () {
        return height2(root);
    }

    private int height2 (Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height2(root.left),height2(root.right));
    }
    // 层序遍历
    public void levelOrderTraversal () {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);

            }
        }
    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * @param e1
     * @param e2
     * @return 返回值等于0，代表e1 等于e2; 返回值大于0，代表e1 大于e2; 返回值小于0，代表e1 小于e2
     */
    private int compare(E e1, E e2) {
        if (this.comparator != null) {
        return this.comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;

        }

        public boolean isLeaf () {
            return this.left == null && this.right == null;
        }

        public boolean hasTowChildren () {
            return this.left != null && this.right != null;
        }
    }
}
