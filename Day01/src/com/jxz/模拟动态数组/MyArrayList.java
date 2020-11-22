package com.jxz.模拟动态数组;

import com.jxz.抽象list.AbstractList;
import com.jxz.集合接口.List;

@SuppressWarnings("ALL")
public class MyArrayList<E> extends AbstractList<E>{

    // 用于存放所有的元素
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    // 构造器
    public MyArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }





    // 获取索引位置的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }



    /**
     * 实际上只是把size置位0，这样get(index),如果index大于0，会直接报错，不会访问到原来的数据
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;

        }
        size = 0;
    }



    /**
     * 在index位置上插入元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return 删除的元素值
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;
        trim();
        return old;
    }


    /**
     * 数组缩容，trim裁剪的意思
     */
    private void trim () {
        int capacity = elements.length;
        int newcapacity = capacity>>1;
        if (size >= (newcapacity) || capacity < DEFAULT_CAPACITY) return;

        E[] newElements = (E[]) new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(capacity + "->缩容" + newcapacity);

    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity
     */
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // size=? , [xx,cc,zz]
        sb.append("size=").append(size).append(" , [");
        for (int i = 0; i < size; i++) {
//            if (i != 0) {
//                sb.append(", ");
//            }
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}

