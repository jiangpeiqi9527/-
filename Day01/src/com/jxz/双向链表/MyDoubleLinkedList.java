//package com.jxz.双向链表;
//
//import com.jxz.手写LinkedList.MyLinkedList;
//import com.jxz.抽象list.AbstractList;
//import com.jxz.集合接口.List;
//
//public class MyDoubleLinkedList<E> extends AbstractList<E> {
//    private Node<E> firstNode;
//    private Node<E> lastNode;
//
//    public MyDoubleLinkedList () {
//        firstNode = new Node<E>(null,null,null);
//    }
//
//    @Override
//    public E get(int index) {
//
//        return node(index).element;
//    }
//
//    @Override
//    public E set(int index, E element) {
//        Node<E> node = node(index);
//        E old = node.element;
//        node.element = element;
//        return old;
//    }
//
//    @Override
//    public int indexOf(E element) {
//        if (element == null) {
//            Node<E> node = this.firstNode;
//            for (int i = 0; i < size; i++) {
//                if (node.element == null) return i;
//                node = node.next;
//            }
//        } else {
//            Node<E> node = this.firstNode;
//            for (int i = 0; i < size; i++) {
//                if (element.equals(node.element)) return i;
//                node = node.next;
//            }
//        }
//        return ELEMENT_NOT_FOUND;
//    }
//
//
//    @Override
//    public void clear() {
//        size = 0;
//        firstNode = null;
//    }
//
//
//    @Override
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//
//        Node<E> prev = index == 0 ? firstNode : node(index - 1);
//        prev.next = new Node<E>(element, prev.next);
//        size++;
//    }
//
//    @Override
//    public E remove(int index) {
//        rangeCheck(index);
//        Node<E> node = node(index);
//        Node<E> temp = index == 0 ? firstNode : node(index - 1);
//        temp.next = temp.next.next;
//        size--;
//        return node.element;
//    }
//
//    private Node<E> node(int index) {
//        rangeCheck(index);
//        if (index < (size>>1)) {
//            Node<E> node = firstNode.next;
//            for (int i = 0; i < index; i++) {
//                node = node.next;
//            }
//        return node;
//        }else{
//
//        }
//
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        // size=? , [xx,cc,zz]
//        sb.append("size=").append(size).append(" , [");
//        Node<E> node = this.firstNode.next;
//        for (int i = 0; i < size; i++) {
////            if (i != 0) {
////                sb.append(", ");
////            }
//            sb.append(node.element);
//            node = node.next;
//            if (i != size - 1) {
//                sb.append(", ");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    private static class Node<E> {
//        E element;
//        Node<E> next;
//        Node<E> prev;
//
//        public Node(Node<E> prev, E element, Node<E> next) {
//            this.element = element;
//            this.next = next;
//            this.prev = prev;
//        }
//    }
//}
