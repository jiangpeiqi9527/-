package com.jxz.抽象list;

import com.jxz.集合接口.List;

public abstract class AbstractList<E> implements List<E> {
    protected int size;
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void add(E element) {
        add(size,element);
    }
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ",Size: " + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
