package com.jxz.sort;

public class HeapSort<E extends Comparable<E>> extends Sort<E> {
    private int heapSize;
    @Override
    protected void sort() {
        // 原地建堆
        // 自下而上的下滤
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }


        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0,heapSize - 1);
            heapSize--;

            // 对0位置进行siftDown
            siftDown(0);
        }
    }

    private void siftDown (int index) {
        E e = array[index];
        int half = heapSize >> 1;
        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        while (index < half) { // 必须保证index位置是非叶子节点
            // 有两种情况
            // 1、只有左子节点
            // 2、同时拥有左右节点

            // 默认为左子节点跟他进行比较
            int childIndex = (index << 1) + 1;
            E child = array[childIndex];

            // 右子节点
            int rightIndex = childIndex + 1;

            // 选出左右子节点最大的那个
            if (rightIndex < heapSize &&
                    cmp(array[rightIndex],child) > 0) {
                childIndex = rightIndex;
                child = array[rightIndex];
            }
            if (cmp(e,child) >= 0) break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = e;
    }
}
