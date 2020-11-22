package com.jxz.数组模拟队列arrSimulationQueue;

public class ArrayQueue {
    private int maxSize; // 表示队列最大的容量
    private int front; //  队列头
    private int rear; // 队列尾
    private int[] arr; // 用于存储数据，模拟队列
    public ArrayQueue (int maxArrSize) {
        maxSize = maxArrSize;
        arr = new int[maxArrSize];
        front = -1; // 指向队列头，分析出front是指向队列头的前一个位置
        rear = -1; // 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    // 判断队列是否满
    public boolean isFull () {
        return rear == maxSize - 1;
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
        arr[++rear] = num;
        return true;
    }

    public int out () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        return arr[++front];
    }

    public void printQueue () {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < maxSize;i++) {
            System.out.printf("arr[%d] = %d",i,arr[i]);
        }
    }
    // 获取队列头数据
    public int peek () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
