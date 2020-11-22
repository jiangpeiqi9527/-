package com.jxz.数组模拟队列arrSimulationQueue;

public class CircleQueueByArray {
    private int maxSize; // 表示队列最大的容量
    private int front; //  就指向队列的第一个元素，front的初始值为 0
    private int rear; // 指向队列最后一个元素的后一个位置，因为希望空出一个空间做约定，初始值为 0
    private int[] arr; // 用于存储数据，模拟队列
    public CircleQueueByArray (int maxArrSize) {
        maxSize = maxArrSize;
        arr = new int[maxArrSize];
    }

    // 判断队列是否满
    public boolean isFull () {
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否空
    public boolean isEmpty () {
        return rear == front;
    }
    public boolean add (int num) {
        if (isFull()) {
            System.out.println("队列已经满了");
            return false;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public int out () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int temporary = arr[front];
        front = (front + 1) % maxSize;
        return temporary;
    }

    public void printQueue () {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size();i++) {
            System.out.printf("arr[%d] = %d",i % maxSize,arr[i % maxSize]);
        }
    }
    // 获取环形队列中有效数据的个数
    public int size () {
        return (rear + maxSize - front) % maxSize;
    }
    // 获取队列头数据
    public int peek () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
