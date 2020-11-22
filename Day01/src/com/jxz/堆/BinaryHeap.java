package com.jxz.堆;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E>{

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;


    public BinaryHeap (E[] elements, Comparator comparator) {
        super(comparator);

        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        }else {
            this.size = elements.length;
            int capacity = elements.length >= DEFAULT_CAPACITY ? elements.length : DEFAULT_CAPACITY;
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    /**
     * 批量建堆
     */
    private void heapify() {
        // 自上而下的上滤
        for (int i = 1; i < this.elements.length; i++) {
            siftUp(i);
        }
        
        // 自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public BinaryHeap (E[] elements) {
        this(elements,null);
    }

    public BinaryHeap (Comparator<E> comparator) {
        this(null,comparator);
    }

    public BinaryHeap () {
        this(null,null);
    }



    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] =  element;
        siftUp(size - 1);
    }

    /**
     * 获取堆顶元素
     * @return
     */
    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        E rootE = elements[0];
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return rootE;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 让index位置的元素上虑
     * @param index
     */
    private void siftUp (int index) {
//            E e = elements[index];
//        while (index > 0) {
//            int parentIndex = (index - 1) >> 1;
//            E p = elements[parentIndex];
//            if (compare(e,p) <= 0) return;
//
//            // 交换index parentIndex 里的内容， 重新赋值index
//            E temp = elements[index];
//            elements[index] = elements[parentIndex];
//            elements[parentIndex] = temp;
//            index = parentIndex;
//        }
        E e = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E p = elements[parentIndex];
            if (compare(e,p) <= 0) break;

            // 将父节点存储在index的位置， 重新赋值index
            elements[index] = elements[parentIndex];
            index = parentIndex;
        }
        elements[index] = e;
    }

    private void siftDown (int index) {
        E e = elements[index];
        int half = size >> 1;
        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        while (index < half) { // 必须保证index位置是非叶子节点
            // 有两种情况
            // 1、只有左子节点
            // 2、同时拥有左右节点

            // 默认为左子节点跟他进行比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            // 右子节点
            int rightIndex = childIndex + 1;

            // 选出左右子节点最大的那个
            if (rightIndex < size && compare(elements[rightIndex],child) > 0) {
                childIndex = rightIndex;
                child = elements[rightIndex];
            }
            if (compare(e,child) >= 0) break;

            elements[index] = child;
            index = childIndex;
        }
        elements[index] = e;
    }

    private void emptyCheck () {
        if (size == 0) throw new IndexOutOfBoundsException("Heap is empty !");
    }



    private void elementNotNullCheck (E element) {
        if (element == null) throw new IllegalArgumentException("element must be not null!");
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "->扩容" + newCapacity);
    }
}
